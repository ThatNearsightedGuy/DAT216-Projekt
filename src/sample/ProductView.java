package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import se.chalmers.ait.dat215.project.Product;

import java.io.IOException;

/**
 * @author Daniel.
 */
public class ProductView extends HBox
{
    private Product product;

    public ProductView (Product product,double size,int amount)
    {
        this.product = product;
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader();
            Pane pane = fxmlLoader.load(getClass().getResource("ProductItem.fxml").openStream());
            ItemController controller = (ItemController) fxmlLoader.getController();
            controller.spinner.getValueFactory().setValue(amount);
            controller.nameLabel.setText(product.getName());
            controller.singlePrice.setText(Double.toString(product.getPrice()) + " " + product.getUnit());
            controller.addButton.setOnAction(e->Main.cartController.addProduct(product, (Integer)controller.spinner.getValue()));
            controller.image.setImage(Utils.dataHandler.getFXImage(product));
            controller.addButton.setOnAction(e->Main.cartController.addProduct(product, (Integer)controller.spinner.getValue()));
            getChildren().add(pane);
            pane.setPrefWidth(size);
        }
        catch (IOException ex)
        {
            System.out.println("couldn't load it yoo.");
        }
    }
    public ProductView (Product product,double size)
    {
        this(product,size,1);
    }
    public Product getProduct(){
        return product;
    }

    final static int HEIGHT = 110;
    public static int getImageHeight(){
        return HEIGHT;
    }


    final static int WIDTH = 110;
    public static int getImageWidth(){
        return WIDTH;
    }
}
