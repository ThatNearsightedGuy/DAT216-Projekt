package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CartController implements Initializable
{

    @FXML
    public Pane itemPane;
    @FXML
    public Button move_button;
    @FXML
    public Button save_Button;
    @FXML
    public Label amount_label;
    @FXML
    public Label sum_label;

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources)
    {
        move_button.setOnAction(e->Main.toggleView());
        save_Button.setOnAction(e -> Utils.newSavedList());
    }

    public void clearCart() {
        ArrayList<CartItemView> tempCartItems = new ArrayList<>();
        ArrayList<Node> tempOthers = new ArrayList<>();
        for(Node n : itemPane.getChildren()) {
            if(n.getClass().equals(CartItemView.class)) {
                CartItemView cartProd = (CartItemView) n;
                tempCartItems.add(cartProd);
            }
            else {
                tempOthers.add(n);
            }
        }

        for (CartItemView c : tempCartItems) {
            Utils.removeItemFromCart(c);
        }

        //Remove all the separators
        itemPane.getChildren().clear();
    }
}
