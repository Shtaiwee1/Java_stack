
class TestOrders {
public static void main(String[] args) {


coffeekiosk newOrderKiosk = new coffeekiosk();
newOrderKiosk.addMenuItem("Mohito" , 4.3 );
newOrderKiosk.addMenuItem("Latte" , 3.3 );
newOrderKiosk.addMenuItem("CaCao" , 2.3 );
// newOrderKiosk.addMenuItemByInput();
newOrderKiosk.addCustomer();
newOrderKiosk.displayMenu();// item must be displayed for this particular object to show the manually added item




}
}