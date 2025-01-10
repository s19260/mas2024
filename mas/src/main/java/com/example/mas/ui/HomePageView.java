package com.example.mas.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import org.springframework.web.client.RestTemplate;

@Route("/")
public class HomePageView extends VerticalLayout {
    private final RestTemplate restTemplate;

    private final Button widokPracownikaButton = new Button("Przejdz do widoku pracownika");
    private final Button widokProjektuButton = new Button("Przejdz do widoku projektu");

    public HomePageView(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

        widokPracownikaButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("pracownik-studia-view")));
        widokProjektuButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("projekt-gry-view")));

        HorizontalLayout buttonLayout = new HorizontalLayout(widokPracownikaButton, widokProjektuButton);
        buttonLayout.setAlignItems(Alignment.CENTER);
        buttonLayout.setSpacing(true);
        buttonLayout.setSizeFull();
        add(buttonLayout);

    }
}
