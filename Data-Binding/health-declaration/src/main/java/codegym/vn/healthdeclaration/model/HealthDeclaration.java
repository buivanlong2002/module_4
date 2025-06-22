package codegym.vn.healthdeclaration.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HealthDeclaration {
    @NotBlank
    private String fullName;

    @NotNull
    private Integer yearOfBirth;

    @NotBlank
    private String gender;

    @NotBlank
    private String nationality;

    @NotBlank
    private String idCard;

    private String vehicleType;
    private String vehicleNumber;
    private String seatNumber;

    @NotBlank
    private String departureDay;

    @NotBlank
    private String returnDay;

    private String visitedPlaces;

    // Contact
    @NotBlank
    private String province;
    @NotBlank
    private String district;
    @NotBlank
    private String ward;
    @NotBlank
    private String address;
    @NotBlank
    private String phone;

    private String email;

    // Symptoms
    private boolean fever;
    private boolean cough;
    private boolean breathShortness;
    private boolean nausea;
    private boolean diarrhea;
    private boolean skinBleeding;
    private boolean skinRash;

    // Exposure
    private boolean animalExposure;
    private boolean closeContact;
}

