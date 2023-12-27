/**
 * O converter ProdutoConverter é responsável por converter objetos da classe Produto em Strings e vice-versa,
 * permitindo a utilização de objetos Produto em componentes de interface gráfica que necessitam de conversão.
 * Ele armazena as instâncias de Produto em um mapa associado ao contexto de faces (FacesContext).
 * 
 * Ao converter um Produto para String, o método getAsString utiliza o ID do produto como chave no mapa,
 * armazenando o produto correspondente. Isso permite recuperar o produto a partir do ID durante a conversão de volta.
 * 
 * Ao converter uma String para Produto, o método getAsObject utiliza o valor da String como chave no mapa para obter
 * o objeto Produto correspondente.
 * 
 * Este converter é anotado com @Named e @FacesConverter, indicando que é gerenciado pelo CDI (Contexts and Dependency Injection)
 * e que deve ser registrado no contexto do FacesConverter com o nome "produtoConverter" e associado à classe Produto.
 */
package br.com.pazzini.converter;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;

import br.com.pazzini.domain.Produto;

@Named
@FacesConverter(value = "produtoConverter", forClass = Produto.class)
public class ProdutoConverter implements Converter {
    
    private static final String key = "br.com.pazzini.converter.ProdutoConverter";
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.isEmpty()) {
            return null;
        }
        return getViewMap(context).get(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object produto) {
        String id = ((Produto) produto).getId().toString();
        getViewMap(context).put(id, produto);
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
