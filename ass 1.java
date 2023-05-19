public class CoffeeShop {
    private String name;
    private List<Map<String, String>> menu;
    private List<String> orders;
    
    public CoffeeShop(String name, List<Map<String, String>> menu) {
        this.name = name;
        this.menu = menu;
        this.orders = new ArrayList<>();
    }
    
    public String addOrder(String item) {
        for (Map<String, String> menuItem : menu) {
            if (menuItem.get("item").equals(item)) {
                orders.add(item);
                return " Order added!"; 
            }
        }
        return "This item is currently unavailable!";
    }
    
    public String fulfillOrder() {
        if (orders.size() > 0) {
            return "The " + orders.get(0) + " is ready!";
        }
        return "All orders have been fulfilled!";
    }
    
    public List<String> listOrders() {
        return orders;
    }
    
    public double dueAmount() {
        double total = 0;
        for (Map<String, String> menuItem : menu) {
            if (orders.contains(menuItem.get("item"))) {
                total += Double.parseDouble(menuItem.get("price"));   
            }
        }
        return total;
    }
    
    public String cheapestItem() {
        Map<String, String> cheapest = menu.get(0);
        for (Map<String, String> menuItem : menu) {
            if (Double.parseDouble(menuItem.get("price")) < Double.parseDouble(cheapest.get("price"))) {
                cheapest = menuItem;
            }
        }
        return cheapest.get("item");
    }
    
    public List<String> drinksOnly() {
        List<String> drinks = new ArrayList<>();
        for (Map<String, String> menuItem : menu) {
            if (menuItem.get("type").equals("drink")) {
                drinks.add(menuItem.get("item"));
            }
        }
        return drinks;
    }   
    
    public List<String> foodOnly() {
        List<String> food = new ArrayList<>();
        for (Map<String, String> menuItem : menu) {
            if (menuItem.get("type").equals("food")) {
                food.add(menuItem.get("item"));
            }
        }
        return food;
    }
}