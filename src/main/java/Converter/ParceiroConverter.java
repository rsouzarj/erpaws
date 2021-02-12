package Converter;

import Parceiro.Parceiro;
import Parceiro.ParceiroService;
import java.io.PrintStream;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;










@FacesConverter("parceiroConverter")
public class ParceiroConverter
  implements Converter
{
  public Object getAsObject(FacesContext fc, UIComponent uic, String string)
  {
    ParceiroService parceiroService = new ParceiroService();
    System.out.println("=========> " + string);
    Parceiro parceiro = parceiroService.buscarParceiroV(string);
    return null;
  }
  
  public String getAsString(FacesContext fc, UIComponent uic, Object o)
  {
    Parceiro parceiro = new Parceiro();
    parceiro = (Parceiro)o;
    

    if (o != null) {
      return parceiro.getNome();
    }
    return null;
  }
}


/* Location:              C:\Users\diogo\Documents\workspace\others\prod erp\deploy\erp3.war!\WEB-INF\classes\Converter\ParceiroConverter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */