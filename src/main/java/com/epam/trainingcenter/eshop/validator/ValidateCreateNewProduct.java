package com.epam.trainingcenter.eshop.validator;

/**
 * @author sburch
 * @version 1.0
 * This class checks input datas
 */


public class ValidateCreateNewProduct {

    //TODO show this at html
    private static final String NAME_REGEX = "^[a-zA-Z]+";
    private static final String DESCRIPTION_REGEX = "^[\\S\\s]+";
    private static final String PRICE_REGEX = ("\\d{2,}[.,]\\d{2,}");
    private static final String IMAGE_URL_REGEX = "(.*/)*.+\\.(png|jpg|gif|bmp|jpeg|PNG|JPG|GIF|BMP|JPEG|WEBP)$";

    /**
     * Validate product name when input one
     *
     * @param name
     * @return name
     */
    public static boolean validateNameWithRegex(String name) {
        return name.matches(NAME_REGEX);
    }

    /**
     * Validate product description when input one
     *
     * @param description
     * @return description
     */
    public static boolean validateDescriptionWithRegex(String description) {
        return description.matches(DESCRIPTION_REGEX);
    }

    /**
     * Validate product price when input one
     *
     * @param price
     * @return price
     */
    public static boolean validatePriceWithRegex(String price) {
        return String.valueOf(price).matches(PRICE_REGEX);
    }

    /**
     * Validate product image_url when input one
     *
     * @param image_url
     * @return image_url
     */
    public static boolean validateImageUrlWithRegex(String image_url) {
        return image_url.matches(IMAGE_URL_REGEX);
    }
}
