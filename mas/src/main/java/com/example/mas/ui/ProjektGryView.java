package com.example.mas.ui;

import com.example.mas.pracownikStudia.PracownikStudia;
import com.example.mas.projektGry.ProjektGry;
import com.example.mas.projektGry.ProjektGryDTO;
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

@Route("projektgryview")
public class ProjektGryView extends VerticalLayout {
    private final RestTemplate restTemplate;

    public ProjektGryView(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

        ResponseEntity<ProjektGryDTO[]> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/v1/projektgry", ProjektGryDTO[].class);
        List<ProjektGryDTO> projektGryList = Arrays.asList(responseEntity.getBody());
        Grid<ProjektGryDTO> grid = new Grid<>(ProjektGryDTO.class, false);

        grid.setItems(projektGryList);
        grid.addColumn(ProjektGryDTO::getId).setHeader("ID Projektu").setSortable(true);
        grid.addColumn(pg -> pg.getLiderZespolu().getImie()).setHeader("Imie lidera").setSortable(true);
        grid.addColumn(ProjektGryDTO::getId).setHeader("ID Projektu").setSortable(true);
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
//                new ComponentRenderer<>(projekt -> {
//                    Grid<PracownikStudia> pracownikGrid = new Grid<>(PracownikStudia.class, false);
//                    pracownikGrid.addColumn(PracownikStudia::getNazwisko).setHeader("Nazwisko");
//                    pracownikGrid.setItems(projekt.getPrzypisaniPracownicy());
//                    return pracownikGrid;
//                })
        ).setHeader("Przypisani pracownicy");
        TextArea readonlyArea = new TextArea();
        readonlyArea.setReadOnly(true);
        readonlyArea.setWidth("100%");
        grid.addCellFocusListener(event -> {
            CellFocusEvent.GridSection section = event.getSection();
            String column = event.getColumn().map(Grid.Column::getHeaderText)
                    .orElse("Not available");
            String row = event.getItem()
                    .map(value -> String.valueOf(projektGryList.indexOf(value)))
                    .orElse("Not available");
            String fullName = event.getItem().map(projektGry -> {
                        if (projektGry.getGra() != null)
                            return projektGry.getGra().getNazwa();
                        else
                            return "";
                    }).orElse("Not available");

            String eventSummary = String.format(
                    "Section: %s%nRzad: %s%nKolumna: %s%nGra: %s", section,
                    row, column, fullName);
            readonlyArea.setValue(eventSummary);
        });
        grid.setAllRowsVisible(true);
        add(grid);
        add(readonlyArea);



    }
}

