/**
 * O converter ClienteConverter é responsável por converter objetos da classe Cliente em Strings e vice-versa,
 * permitindo a utilização de objetos Cliente em componentes de interface gráfica que necessitam de conversão.
 * Ele armazena as instâncias de Cliente em um mapa associado ao contexto de faces (FacesContext).
 * 
 * Ao converter um Cliente para String, o método getAsString utiliza o ID do cliente como chave no mapa,
 * armazenando o cliente correspondente. Isso permite recuperar o cliente a partir do ID durante a conversão de volta.
 * 
 * Ao converter uma String para Cliente, o método getAsObject utiliza o valor da String como chave no mapa para obter
 * o objeto Cliente correspondente.
 * 
 * Este converter é anotado com @Named e @FacesConverter, indicando que é gerenciado pelo CDI (Contexts and Dependency Injection)
 * e que deve ser registrado no contexto do FacesConverter com o nome "clienteConverter" e associado à classe Cliente.
 */
package br.com.pazzini.converter;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import br.com.pazzini.domain.Cliente;

@Named
@FacesConverter(value = "clienteConverter", forClass = Cliente.class)
public class ClienteConverter implements Converter {
    
    private static final String key = "br.com.pazzini.converter.ClienteConverter";
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.isEmpty()) {
            return null;
        }
        return getViewMap(context).get(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object cliente) {
        String id = ((Cliente) cliente).getId().toString();
        getViewMap(context).put(id, cliente);
        return id;
    }
    
    private Map<String, Object> getViewMap(FacesContext context) {
        Map<String, Object> viewMap = context.getViewRoot().getViewMap();
        @SuppressWarnings({ "unchecked", "rawtypes" })
        Map<String, Object> idMap = (Map) viewMap.get(key);
        if (idMap == null) {
            idMap = new HashMap<String, Object>();
            viewMap.put(key, idMap);
        }
        return idMap;
    }

}
