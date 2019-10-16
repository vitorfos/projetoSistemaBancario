
package br.com.foton.projeto.sistemabanco.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import br.com.foton.projeto.sistemabanco.entity.Conta;
import br.com.foton.projeto.sistemabanco.entity.Transacao;
import br.com.foton.projeto.sistemabanco.enums.TipoOperacao;

@SuppressWarnings("unused")
public class HistoricoTransacaoDao extends Dao<Transacao>
{

   private EntityManager em; // TODO: nao utilizado

   public HistoricoTransacaoDao()
   {
      super(Transacao.class);
   }

   @Inject
   private Transacao transacao; // TODO: Classe Pojo não fazer inject, criar instancia com new
   // TODO: Utilizar BigDecimal em valor

   public Boolean gravarHistorico(Conta contaOrigem, Conta contaDestino, double valor, TipoOperacao tipoOperacao)
   {

      try
      {

         transacao.setNumeroContaOrigem(contaOrigem.getNumero());
         transacao.setIdContaOrigem(contaOrigem.getIdConta());
         transacao.setIdContaDestino(contaDestino.getIdConta());
         transacao.setTipoOperacao(tipoOperacao);
         transacao.setNumeroContaDestino(contaDestino.getNumero());
         transacao.setValorTransacao(valor);

         salvar(transacao);
         return true;

      }
      catch (Exception e)
      {
         e.printStackTrace();
         return false;
      }
   }

}
