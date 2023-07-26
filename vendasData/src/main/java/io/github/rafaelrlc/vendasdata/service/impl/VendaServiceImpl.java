package io.github.rafaelrlc.vendasdata.service.impl;

import io.github.rafaelrlc.vendasdata.domain.entity.Cliente;
import io.github.rafaelrlc.vendasdata.domain.entity.Produto;
import io.github.rafaelrlc.vendasdata.domain.entity.Venda;
import io.github.rafaelrlc.vendasdata.domain.entity.VendaProduto;
import io.github.rafaelrlc.vendasdata.domain.repository.ClientesRepository;
import io.github.rafaelrlc.vendasdata.domain.repository.ProdutosRepository;
import io.github.rafaelrlc.vendasdata.domain.repository.VendaProdutosRepository;
import io.github.rafaelrlc.vendasdata.domain.repository.VendasRepository;
import io.github.rafaelrlc.vendasdata.exception.RegraNegocioException;
import io.github.rafaelrlc.vendasdata.rest.dto.VendaDTO;
import io.github.rafaelrlc.vendasdata.rest.dto.VendaProdutoDTO;
import io.github.rafaelrlc.vendasdata.service.VendaService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

// {
//
// "cliente" : "Rafael",
// "total" : "12.54",
// "dataVenda" : "12/12/2020",
// "items" :  "[{ produto : "1",
//                "quantidade" : "5"
//             }]"

//  }


@Service
@RequiredArgsConstructor
public class VendaServiceImpl implements VendaService {

    private final VendasRepository vendaRepository;
    private final ClientesRepository clientesRepository;
    private final ProdutosRepository produtosRepository;
    private final VendaProdutosRepository itemsPedidoRepository;

    @Override
    @Transactional
    public Venda save (VendaDTO dto) {

        Cliente cliente = clientesRepository.findById(dto.getCliente())
                .orElseThrow(() -> new RegraNegocioException("Invalid Client ID"));

        Venda venda = new Venda();
        venda.setTotal(dto.getTotal());
        venda.setDataVenda(LocalDate.now());
        venda.setCliente(cliente);

        List<VendaProduto> itemsVenda = converterItems(dto.getItems(), venda);

        vendaRepository.save(venda); // salva a venda no banco
        itemsPedidoRepository.saveAll(itemsVenda); // salva os itens vendidos no banco

        venda.setItens(itemsVenda);

        return null;
    }

    public List<VendaProduto> converterItems (List<VendaProdutoDTO> items, Venda venda ) {

        if (items.isEmpty()) {
            throw new RegraNegocioException("Nao e possivel realizar um pedido sem items");
        }

        return items
                .stream()
                .map(dto -> {
                    Integer idProduto = dto.getProduto();

                    Produto produto = produtosRepository.findById(idProduto).orElseThrow(() -> new RegraNegocioException(("Codigo de produto invalido" + idProduto)));

                    VendaProduto vendaProduto = new VendaProduto();
                    vendaProduto.setQuantidade(dto.getQuantidade());
                    vendaProduto.setVenda(venda);
                    vendaProduto.setProduto(produto);

                    return vendaProduto;

        }).collect(Collectors.toList());
    }


}
