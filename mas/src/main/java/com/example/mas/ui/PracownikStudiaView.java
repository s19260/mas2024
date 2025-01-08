package com.example.mas.ui;

import com.example.mas.pracownikStudia.PracownikStudia;
import com.example.mas.pracownikStudia.PracownikStudiaDTO;
import com.example.mas.projektGry.ProjektGry;
import com.example.mas.projektGry.ProjektGryDTO;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.CellFocusEvent;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Route("pracownik-studia-view")
public class PracownikStudiaView extends VerticalLayout {
    private final RestTemplate restTemplate;

    public PracownikStudiaView(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

        ResponseEntity<PracownikStudiaDTO[]> responseEntity = restTemplate.getForEntity(
                "http://localhost:8080/api/v1/pracownikstudia", PracownikStudiaDTO[].class);
        List<PracownikStudiaDTO> pracownikStudiaList = Arrays.asList(responseEntity.getBody());
        Grid<PracownikStudiaDTO> grid = new Grid<>(PracownikStudiaDTO.class, false);
        grid.setItems(pracownikStudiaList);

        grid.addColumn(PracownikStudiaDTO::getId).setHeader("ID Pracownika").setSortable(true);
        grid.addColumn(PracownikStudiaDTO::getImie).setHeader("Imie Pracownika").setSortable(true);
        grid.addColumn(PracownikStudiaDTO::getNazwisko).setHeader("Nazwisko Pracownika").setSortable(true);

        grid.addColumn(pracownikStudia -> {
            if (pracownikStudia.getPrzypisaneProjektyGry() != null)
               // return pracownikStudia.getPrzypisaneProjektyGry().stream().map(ProjektGry::getId).toList();
                return pracownikStudia.getProjektGry().getId();
            else return "";
                }


        ).setHeader("Aktualny projekt").setSortable(true);

        grid.addColumn(new ComponentRenderer<>(pracownikStudia -> {
            Button editButton = new Button("Edytuj");
            editButton.addClickListener(event -> {
                getUI().ifPresent(ui -> ui.navigate("edit-pracownik-studia/" + pracownikStudia.getId()));
            });
            return editButton;
        })).setHeader("Akcja");

        TextArea readonlyArea = new TextArea();
        readonlyArea.setReadOnly(true);
        readonlyArea.setWidth("100%");

        grid.setAllRowsVisible(true);

        add(grid, readonlyArea);

    }
}
