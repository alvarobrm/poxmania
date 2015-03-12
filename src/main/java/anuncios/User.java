package anuncios;

import java.util.ArrayList;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.context.*;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS) 
public class User {
   private ArrayList<Product> cart=new ArrayList<>();
   
   public void setCart(ArrayList<Product> cart) {
      this.cart = cart;
   }
   
   public ArrayList<Product> getCart() {
      return cart;
   } 
   
   public void addToCart(Product p){
	   cart.add(p);
   }
   
   public int CartSize(){
	   return cart.size();
   }
}
