package Notifications;

import java.io.Serializable;
import java.util.List;

import Gestions.GestionMyBook;
import Model.MyBooks;
import Services.MyBookService;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;


@Named
@RequestScoped
public class NotificacionBean {

    @Inject
    private MyBookService myBookService;

    private List<MyBooks> overdueBooks;

    @PostConstruct
    public void init() {
        try {
            int userId = getCurrentUserId();
            overdueBooks = myBookService.getOverdueBooks(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<MyBooks> getOverdueBooks() {
        return overdueBooks;
    }

    private int getCurrentUserId() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String userIdParam = facesContext.getExternalContext().getRequestParameterMap().get("userId");
        return Integer.parseInt(userIdParam);
    }
}
