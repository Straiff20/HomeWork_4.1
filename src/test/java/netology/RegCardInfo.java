package netology;

import lombok.AllArgsConstructor;

@lombok.Data
@AllArgsConstructor
public class RegCardInfo {
    private String city;
    private String fullName;
    private String phoneNumber;
}