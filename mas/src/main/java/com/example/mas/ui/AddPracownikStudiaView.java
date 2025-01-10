package com.example.mas.ui;
import com.example.mas.pracownikStudia.PracownikStudiaDTO;
import com.example.mas.pracownikStudia.PracownikStudiaDoZapisuDTO;
import com.example.mas.pracownikStudia.PracownikStudiaRepository;
import com.example.mas.pracownikStudia.PracownikStudiaService;
import com.example.mas.projektGry.ProjektGryDTO;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@Route("add-pracownik-studia")
public class AddPracownikStudiaView extends VerticalLayout {
    private final RestTemplate restTemplate;

    private Long id;
    private String imie;
    private String nazwisko;
    private boolean aktualnyStatusZatrudnienia;


    private final TextField imieField = new TextField("Imie");
    private final TextField nazwiskoField = new TextField("Nazwisko");
    //private final BooleanField aktualnyStatusField = new BooleanField("Aktualny status");



    private final Button addButton = new Button("Dodaj nowego pracownika");
    private final Button cancelButton = new Button("Anuluj");
    private final Button homePageButton = new Button("Strona glowna");


    public AddPracownikStudiaView(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

        addButton.addClickListener(e ->  registerNewPracownikStudia());

        HorizontalLayout buttonLayout = new HorizontalLayout(cancelButton, addButton);
        add(imieField, nazwiskoField, buttonLayout);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setSizeFull();
    }

    //public void addPracownikStudia(){
    public String registerNewPracownikStudia () {
        String url = "http://localhost:8080/add-pracownik-studia";

        PracownikStudiaDoZapisuDTO dto = new PracownikStudiaDoZapisuDTO(imieField.getValue(), nazwiskoField.getValue(), true);
        Notification.show("Pracownik dodany pomyslnie!", 3000, Notification.Position.MIDDLE);

        return restTemplate.postForObject(url, dto, String.class);

    }

}
