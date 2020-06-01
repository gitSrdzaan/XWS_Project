package xml.team.model;

public class Codebook {
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.Eager)
    private List<String> car_model;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.Eager)
    private List<String> fuel_type;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.Eager)
    private List<String> car_class;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.Eager)
    private List<String> car_transmission;


}
