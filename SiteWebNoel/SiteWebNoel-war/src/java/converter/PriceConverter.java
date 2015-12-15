package converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

@FacesConverter("priceConverter")
public class PriceConverter implements javax.faces.convert.Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        double price = Double.parseDouble(value.toString());
        price = Math.floor(price * 100) / 100;
        return String.valueOf(price) + " €";
    }
}
