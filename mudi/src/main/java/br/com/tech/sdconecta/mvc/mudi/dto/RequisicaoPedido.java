package br.com.tech.sdconecta.mvc.mudi.dto;

import br.com.tech.sdconecta.mvc.mudi.model.Pedido;
import jakarta.validation.constraints.NotBlank;

public class RequisicaoPedido {

    @NotBlank
    private String productName;
    @NotBlank
    private String productUrl;
    @NotBlank
    private String imageUrl;
    private String description;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pedido toPedido() {
        Pedido pedido = new Pedido();
        pedido.setDescription(description);
        pedido.setProductName(productName);
        pedido.setImageUrl(imageUrl);
        pedido.setProductUrl(productUrl);

        return pedido;
    }
}
