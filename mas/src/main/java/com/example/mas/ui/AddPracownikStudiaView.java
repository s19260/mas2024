package com.example.mas.ui;
import com.example.mas.deweloper.DeweloperDTO;
import com.example.mas.deweloper.DeweloperDoZapisuDTO;
import com.example.mas.pracownikStudia.PracownikStudiaDTO;
import com.example.mas.pracownikStudia.PracownikStudiaDoZapisuDTO;
import com.example.mas.pracownikStudia.PracownikStudiaRepository;
import com.example.mas.pracownikStudia.PracownikStudiaService;
import com.example.mas.projektGry.ProjektGryDTO;
import com.example.mas.tester.TesterDTO;
import com.example.mas.testerEndToEnd.TesterEndToEndDTO;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Route("dodaj-pracownika-studia")
public class AddPracownikStudiaView extends VerticalLayout {
    private final RestTemplate restTemplate;

    private Long id;
    private String imie;
    private String nazwisko;
    private boolean aktualnyStatusZatrudnienia;


    private final TextField imieField = new TextField("Imie");
    private final TextField nazwiskoField = new TextField("Nazwisko");
    private final TextField adresZamieszkaniaField = new TextField("Adres zamieszkania");
    //private final BooleanField aktualnyStatusField = new BooleanField("Aktualny status");



    private final Button addButton = new Button("Dodaj nowego pracownika");
    private final Button cancelButton = new Button("Anuluj");
    private final Button homePageButton = new Button("Strona glowna");


    public AddPracownikStudiaView(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

        ComboBox<String> stanowiskoComboBox = new ComboBox<>("Wybierz stanowisko");
        stanowiskoComboBox.setItems("Deweloper", "Tester", "Tester-End-To-End");

        MultiSelectComboBox<String> jezykiComboBox = new MultiSelectComboBox<>("Wybierz jezyki programowania");
        jezykiComboBox.setItems("Java", "Python", "JavaScript", "C++", "Kotlin");
        jezykiComboBox.setVisible(false);
        jezykiComboBox.setPlaceholder("Wybierz jezyki programowania");

        stanowiskoComboBox.addValueChangeListener(event -> {
            if ("Deweloper".equals(event.getValue())) {
                jezykiComboBox.setVisible(true);
            } else {
                jezykiComboBox.setVisible(false);
            }
        });


        Set<String> wybraneJezyki = new HashSet<>(jezykiComboBox.getValue());

//        if ("Deweloper".equals(stanowiskoComboBox.getValue())) {
//            DeweloperDTO deweloper = new DeweloperDTO(imieField.getValue(), nazwiskoField.getValue(),  true, adresZamieszkaniaField.getValue(),selectedLanguages.stream().toList() );
//        } else {
//            PracownikStudiaDoZapisuDTO pracownik = new PracownikStudiaDoZapisuDTO(imieField.getValue(), nazwiskoField.getValue(), true);
//        }


        cancelButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("/")));
        addButton.addClickListener(e -> {
            String stanowisko = stanowiskoComboBox.getValue();

            if (stanowisko == null) {
                Notification.show("Proszę wybrać stanowisko.", 3000, Notification.Position.MIDDLE);
                return;
            }

            PracownikStudiaDTO pracownik = null;

            // Register based on selected position
            if ("Deweloper".equals(stanowisko)) {
                if (jezykiComboBox.getValue().size() < 2) {
                    Notification.show("Proszę wybrać co najmniej dwa języki programowania.", 3000, Notification.Position.MIDDLE);
                    return;
                }
                pracownik = registerNewDeweloper();
            } else if ("Tester".equals(stanowisko)) {
                pracownik = registerNewTester();
            } else if ("Tester-End-To-End".equals(stanowisko)) {
                pracownik = registerNewTesterEndToEnd();
            }

//            if (pracownik == null || pracownik.getImie() == null || pracownik.getNazwisko() == null) {
//                Notification.show("Brak wymaganych danych :(", 3000, Notification.Position.MIDDLE);
//            } else {
                Notification.show("Pracownik " + pracownik.getImie() + " " + pracownik.getNazwisko() + " dodany pomyslnie!", 3000, Notification.Position.MIDDLE);
                getUI().ifPresent(ui -> ui.navigate("/"));
//            }
        });
    }
//        addButton.addClickListener(e ->  {
//            PracownikStudiaDTO pracownik = registerNewPracownikStudia();
//           if (pracownik.getImie() == null || pracownik.getNazwisko() == null) {
//               Notification.show("Brak wymaganych danych :(", 3000, Notification.Position.MIDDLE);
//
//           }
//           else {
//               if (jezykiComboBox.getValue().size() < 2) {
//                   Notification.show("Proszę wybrać co najmniej dwa języki programowania.");
//               } else {
//
//                   Notification.show("Pracownik " + pracownik.getImie() + " " + pracownik.getNazwisko() + " dodany pomyslnie!", 3000, Notification.Position.MIDDLE);
//                   getUI().ifPresent(ui -> ui.navigate("/"));
//               }
//           }
//     });
//
//        HorizontalLayout buttonLayout = new HorizontalLayout(cancelButton, addButton);
//        add(imieField, nazwiskoField, stanowiskoComboBox, jezykiComboBox, buttonLayout);
//        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
//        setSizeFull();
//    }

    public PracownikStudiaDTO registerNewPracownikStudia () {
        String url = "http://localhost:8080/api/v1/pracownikstudia/add-pracownik-studia";
        DatePicker dataDodaniaPracownika = new DatePicker("");
        dataDodaniaPracownika.setValue(LocalDate.now());
        PracownikStudiaDoZapisuDTO dto = new PracownikStudiaDoZapisuDTO(imieField.getValue(), nazwiskoField.getValue(), true, dataDodaniaPracownika.getValue());
        return restTemplate.postForObject(url, dto, PracownikStudiaDTO.class);
    }

    public DeweloperDTO registerNewDeweloper() {
        String url = "http://localhost:8080/api/v1/pracownikstudia/add-deweloper";
        DeweloperDoZapisuDTO dto = new DeweloperDoZapisuDTO(imieField.getValue(), nazwiskoField.getValue(), true, LocalDate.now());
        return restTemplate.postForObject(url, dto, DeweloperDTO.class);
    }

    public TesterDTO registerNewTester() {
        String url = "http://localhost:8080/api/v1/pracownikstudia/add-tester";
        TesterDTO dto = new TesterDTO(imieField.getValue(), nazwiskoField.getValue(), true, LocalDate.now());
        return restTemplate.postForObject(url, dto, TesterDTO.class);
    }

    public TesterDTO registerNewTesterEndToEnd() {
        String url = "http://localhost:8080/api/v1/pracownikstudia/add-tester";
        TesterEndToEndDTO dto = new TesterEndToEndDTO(imieField.getValue(), nazwiskoField.getValue(), true, LocalDate.now());
        return restTemplate.postForObject(url, dto, TesterDTO.class);
    }


}
