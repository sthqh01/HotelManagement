/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.object;

/**
 *
 * @author danielhuynh
 */
public class Service 
{
    private final String name, category, detail;
    private final Double price;
    private final Long inventoryQuantity;

    public Service(String name, String category, String detail, Double price, Long inventoryQuantity)
    {
        this.name = name;
        this.category = category;
        this.detail = detail;
        this.price = price;
        this.inventoryQuantity = inventoryQuantity;
    }
    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDetail() {
        return detail;
    }

    public Double getPrice() {
        return price;
    }

    public Long getInventoryQuantity() {
        return inventoryQuantity;
    }
}
