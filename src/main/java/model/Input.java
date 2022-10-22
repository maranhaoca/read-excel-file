package model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Input {

    private String macroClass;
    private String macroClasseDescription;
    private String classe;
    private String classeDescription;
    private String type;
    private String typeDescription;
    private String classificationCode;
    private String description;
    private String unity;
    private String priceMedium;
    private String priceOrigin;
    private String institution;
}
