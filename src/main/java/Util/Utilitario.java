package Util;

import org.jrimum.vallia.digitoverificador.Modulo;







public class Utilitario
{
  public String BRADESCOcalcularDigitoVerificadorNossoNumero(String nossoNumero)
  {
    String retorno = "0";
    
    String formula = "06" + nossoNumero;
    
    int restoDivisao = Modulo.calculeMod11(formula, 2, 7);
    
    int restoSubtracao = 11 - restoDivisao;
    
    if (restoDivisao == 0) {
      retorno = "0";
    }
    else if (restoSubtracao == 10) {
      retorno = "P";
    } else {
      retorno = "" + restoSubtracao;
    }
    
    return retorno;
  }
  
  public <T> T nvl(T arg0, T arg1) {
    return arg0 == null ? arg1 : arg0;
  }
}

