package com.epam.trainingcenter.eshop.service;

import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {

    private static final Map<String, Service> SERVICE_MAP = new HashMap<>();
    private static final ServiceFactory SERVICE_FACTORY = new ServiceFactory();

    static {
        SERVICE_MAP.put("/registration", new RegistrationUserService()) ;
        SERVICE_MAP.put("/login", new LoginUserService());
        SERVICE_MAP.put("/home", new GetAllProductsService());
        SERVICE_MAP.put("/product", new GetOneProductService());
        SERVICE_MAP.put("/addProductToCart", new AddProductToCartService());
        SERVICE_MAP.put("/cart", new GetAllProductFromCartService());
        SERVICE_MAP.put("/deleteProductFromCart", new DeleteProductFromCartService());
        SERVICE_MAP.put("/createProduct", new CreateNewProductService());
        SERVICE_MAP.put("/updateProduct", new UpdateProductService());
        SERVICE_MAP.put("/deleteProduct", new DeleteProductService());
        SERVICE_MAP.put("/allUsers", new GetAllUsersService());
        SERVICE_MAP.put("/activateUser", new ActivateUserService());
        SERVICE_MAP.put("/deactivateUser", new DeactivateUserService());
        SERVICE_MAP.put("/logout", new LogOutUserService());
        SERVICE_MAP.put("/createOrder", new CreateOrderFromCartProductsService());
        SERVICE_MAP.put("/ordersAdmin", new ListOfOrdersForAdminService());
        SERVICE_MAP.put("/ordersUser", new ListOfOrdersForUsersService());
        SERVICE_MAP.put("/orderDetail", new OrderDetailAdminService());
        SERVICE_MAP.put("/changeStatus", new ChangeStatusService());
        SERVICE_MAP.put("/DeleteOrderAdminService", new DeleteOrderAdminService());
        SERVICE_MAP.put("/changeLanguage", new ChangeLanguageService());
        SERVICE_MAP.put("/order", new OrderService());
    }

    public Service getService(String request) {
        Service service = SERVICE_MAP.get("/error");

        for (Map.Entry<String, Service> pair : SERVICE_MAP.entrySet()) {
            if (request.equalsIgnoreCase(pair.getKey())) {
                service = SERVICE_MAP.get(pair.getKey());
            }
        }
        return service;
    }

    public static ServiceFactory getInstance() {
        return SERVICE_FACTORY;
    }

}
