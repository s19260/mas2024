package com.example.mas.ui;

import com.example.mas.gra.GraDTO;
import com.example.mas.liderZespolu.LiderZespolu;
import com.example.mas.liderZespolu.LiderZespoluDTO;
import com.example.mas.liderZespolu.LiderZespoluMapper;
import com.example.mas.projektGry.ProjektGry;
import com.example.mas.projektGry.ProjektGryDTO;
import com.example.mas.projektGry.ProjektGryDoZapisuDTO;
import com.vaadin.flow.component.ItemLabelGenerator;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Route("dodaj-projekt-gry")
public class AddProjektGryView extends VerticalLayout  {
    private final RestTemplate restTemplate;

    private final NumberField idField = new NumberField("ID");
    private final ComboBox<LiderZespoluDTO> liderZespoluComboBox = new ComboBox<>("Lider Zespolu");
    private final NumberField budzetField = new NumberField("Budzet");
    private final NumberField kosztUtrzymaniaZespoluField = new NumberField("Koszt Utrzymania Zespolu");
    private final TextField wymaganySprzetField = new TextField("Wymagany sprzet");
    private final ComboBox<GraDTO> graDTOComboBox = new ComboBox<>("Wybierz gre");


    private final Button addButton = new Button("Zapisz");
    private final Button cancelButton = new Button("Cofnij");
  //  private final LiderZespoluMapper liderZespoluMapper;

    private String projektId;




    public AddProjektGryView(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        budzetField.setMin(0);


        ResponseEntity<GraDTO[]> responseEntity = restTemplate.getForEntity(
                "http://localhost:8080/api/v1/gra/getAllGryNull", GraDTO[].class);
        List<GraDTO> gry = Arrays.asList(responseEntity.getBody());




        graDTOComboBox.setItems(gry);
        graDTOComboBox.setItemLabelGenerator(new ItemLabelGenerator<GraDTO>() {
            @Override
            public String apply(GraDTO graDTO) {
                return graDTO.getNazwa();
            }
        });


        addButton.addClickListener(e -> {
            if(budzetField.getValue() == null || budzetField.getValue().equals("")
                    || kosztUtrzymaniaZespoluField.getValue() == null
                    || kosztUtrzymaniaZespoluField.getValue().equals("")
                    || wymaganySprzetField.getValue() == null
                    || wymaganySprzetField.getValue().equals("")
            || graDTOComboBox.getValue() == null)
            {
                Notification.show("Podaj wymagane dane", 3000, Notification.Position.MIDDLE);

            } else {
                ProjektGryDoZapisuDTO projektGry = new ProjektGryDoZapisuDTO(Math.round(budzetField.getValue()),
                        Math.round(budzetField.getValue())*0.25,
                        kosztUtrzymaniaZespoluField.getValue(),
                        wymaganySprzetField.getValue(), graDTOComboBox.getValue() );
                ProjektGryDoZapisuDTO projektGryPoZapisie = addNewProjektGryDoZapisu(projektGry);
                Notification.show(projektGryPoZapisie.toString() + " dodany pomyslnie", 3000, Notification.Position.MIDDLE);

            }
                });

        cancelButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("/home")));

        HorizontalLayout buttonLayout = new HorizontalLayout(cancelButton, addButton);
        add(budzetField, graDTOComboBox, kosztUtrzymaniaZespoluField, wymaganySprzetField, buttonLayout);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setSizeFull();
    }

    private ProjektGryDoZapisuDTO addNewProjektGryDoZapisu(ProjektGryDoZapisuDTO projektGryDoZapisuDTO) {
        String url = "http://localhost:8080/api/v1/projektgry/add-projekt-gry";
        return restTemplate.postForObject(url, projektGryDoZapisuDTO, ProjektGryDoZapisuDTO.class);
    }

}


