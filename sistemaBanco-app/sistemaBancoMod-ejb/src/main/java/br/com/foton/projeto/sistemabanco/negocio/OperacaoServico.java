
package br.com.foton.projeto.sistemabanco.negocio;

import br.com.foton.projeto.sistemabanco.constantes.Constante;

public class OperacaoServico
{

   public static double bonificacaoVariavelCredito(double valor)
   {
      double bonus;
      if (valor > Constante.ZERO && valor <= Constante.MIL_REAIS)
      {
         bonus = Constante.BONUS_OP_CREDITO_MIL;
      }
      else if (valor > Constante.MIL_REAIS && valor <= Constante.CEM_MIL_REAIS)
      {
         bonus = Constante.BONUS_OP_CREDITO_CEM_MIL;
      }
      else
      {
         bonus = Constante.BONUS_OP_CREDITO_ALTOS_VALORES;
      }
      return valor * bonus;
   }
}
