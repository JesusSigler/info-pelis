package com.aula114.bean;

import com.aula114.model.Slider;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Jesús Sigler Martínez
 */
@ManagedBean(name = "slider")
public class SliderView {

    private List<Slider> slider;

    @PostConstruct
    public void init() {
        slider = new ArrayList<>();
        //Foto(url), Titulo, descripcion(alt de la imagen)
        slider.add(new Slider("Black-panther.jpg","Black Phanter", "Black-Phanter"));
        slider.add(new Slider("jumanji2.jpg","Jumanji2", "Jumanji2"));
        slider.add(new Slider("pacificRim.jpg","Pacific Rim","Pacific-Rim"));
        slider.add(new Slider("sombrasLiberadas.jpg","50 sombras Liberadas", "Sombras-Liberadas"));
        slider.add(new Slider("tombRaider.jpg","Tomb Raider", "Tomb-Raider"));
        slider.add(new Slider("infinityWars.jpg","Marvel Avengers - Infinity Wars", "Infinity-Wars"));
    }

    public List<Slider> getSlider() {
        return slider;
    }

}
