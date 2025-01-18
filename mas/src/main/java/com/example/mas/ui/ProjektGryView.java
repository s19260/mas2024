package com.example.mas.ui;

import com.example.mas.pracownikStudia.PracownikStudia;
import com.example.mas.projektGry.ProjektGryDTO;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.CellFocusEvent;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Route("projekt-gry-view")
public class ProjektGryView extends VerticalLayout {
    private final RestTemplate restTemplate;
    private final Button homePageButton = new Button("Strona główna");


    public ProjektGryView(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

        ResponseEntity<ProjektGryDTO[]> responseEntity = restTemplate.getForEntity(
                "http://localhost:8080/api/v1/projektgry", ProjektGryDTO[].class);
        List<ProjektGryDTO> projektGryList = Arrays.asList(responseEntity.getBody());
        Grid<ProjektGryDTO> grid = new Grid<>(ProjektGryDTO.class, false);
        grid.setItems(projektGryList);

        grid.addColumn(ProjektGryDTO::getId).setHeader("ID Projektu").setSortable(true);

        grid.addColumn(pg ->
        {
            if(pg.getLiderZespolu() != null){
            return pg.getLiderZespolu().getImie() + " " + pg.getLiderZespolu().getNazwisko();
            }
            else
                return "";
        }).setHeader("Lider").setSortable(true);
        grid.addColumn(ProjektGryDTO::getBudzet).setHeader("Budzet projektu");
        grid.addColumn(ProjektGryDTO::getKosztMarketingu).setHeader("Koszt marketingu");
        grid.addColumn(ProjektGryDTO::getKosztUtrzymaniaZespolu).setHeader("Koszt utrzymania zespolu");
        grid.addColumn(ProjektGryDTO::getWymaganySprzet).setHeader("Wymagany sprzet");
        grid.addColumn(projektGry -> {
            if (projektGry.getPrzedstawicielWydawcy() != null)
                return projektGry.getPrzedstawicielWydawcy().getImie();
            else
                return "";
        }).setHeader("Przedstawiciel wydawcy");

        grid.addColumn(
                projektGry -> {
                    if (projektGry.getPrzypisaniPracownicy() != null)
                        return projektGry.getPrzypisaniPracownicy().stream().map(PracownikStudia::getNazwisko).toList();
                    else
                        return "";
                }
        ).setHeader("Przypisani pracownicy");

        grid.addColumn(new ComponentRenderer<>(projektGry -> {
            Button editButton = new Button("Edytuj");
            editButton.addClickListener(event -> {
                getUI().ifPresent(ui -> ui.navigate("edit-projekt-gry/" + projektGry.getId()));
            });
            return editButton;
        })).setHeader("Akcja");


        homePageButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("/")));

        HorizontalLayout buttonLayout = new HorizontalLayout(homePageButton);


        add(homePageButton, buttonLayout);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        setSizeFull();

        grid.setAllRowsVisible(true);
        add(grid);
    }
}
