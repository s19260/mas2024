package com.example.mas.ui;

import com.example.mas.pracownikStudia.PracownikStudia;
import com.example.mas.pracownikStudia.PracownikStudiaDTO;
import com.example.mas.pracownikStudia.PracownikStudiaService;
import com.example.mas.pracownikStudia.ProjektGryDetailsDTO;
import com.example.mas.projektGry.ProjektGry;
import com.example.mas.projektGry.ProjektGryDTO;
import com.example.mas.projektGry.ProjektGryRepository;
import com.example.mas.projektGry.ProjektGryService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
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
    private final Button homePageButton = new Button("Strona główna");


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
            if (pracownikStudia.getProjektGry() != null)
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
        })).setHeader("Edycja");

        grid.addColumn(new ComponentRenderer<>(pracownikStudia -> {
            Button deleteButton = new Button("Usun");

            deleteButton.addClickListener(event -> {

                String url = "http://localhost:8080/api/v1/pracownikstudia/" + pracownikStudia.getId();
                restTemplate.delete(url);



                Notification.show("Pracownik usuniety pomyslnie", 3000, Notification.Position.MIDDLE);
                getUI().ifPresent(ui -> UI.getCurrent().getPage().reload());
            });

            return deleteButton;

        })).setHeader("Usuniecie");

        homePageButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("/home")));

        HorizontalLayout buttonLayout = new HorizontalLayout(homePageButton);


        add(homePageButton, buttonLayout);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setSizeFull();

        grid.setAllRowsVisible(true);

        add(grid);
    }
}
