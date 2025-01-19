package com.example.mas.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import org.springframework.web.client.RestTemplate;

@Route("/home")
public class HomePageView extends VerticalLayout {
    private final RestTemplate restTemplate;

    private final Button widokPracownikaButton = new Button("Przejdz do widoku pracownika");
    private final Button widokProjektuButton = new Button("Przejdz do widoku projektu");
    private final Button widokDodawaniaPracownikaButton = new Button(("Dodaj nowego pracownika"));

    public HomePageView(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

        H1 header = new H1("Strona główna panelu zarządzania projektami i pracownikami");
        widokPracownikaButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("pracownik-studia-view")));
        widokProjektuButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("projekt-gry-view")));
        widokDodawaniaPracownikaButton.addClickListener(e -> getUI().ifPresent(ui -> ui.navigate("dodaj-pracownika-studia")));

        Footer footer = new Footer();

        HorizontalLayout buttonLayout = new HorizontalLayout(widokDodawaniaPracownikaButton, widokPracownikaButton, widokProjektuButton);
        buttonLayout.setAlignItems(Alignment.CENTER);
        buttonLayout.setSpacing(true);
        buttonLayout.setSizeFull();
        add(header, buttonLayout,footer);
        footer.add(new Div(new H2("Projekt MAS - S19260")));

    }
}
