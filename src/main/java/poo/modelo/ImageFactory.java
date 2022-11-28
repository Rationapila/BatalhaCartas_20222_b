package poo.modelo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageFactory {
	private static ImageFactory imgf = new ImageFactory();
	private Map<String, Image> images;

	public static ImageFactory getInstance() {
		return imgf;
	}

	private ImageFactory() {
		images = new HashMap<>();
	}

	public static String id2File(String imgId) {
		switch (imgId) {
		case "img1":
			return ("/imagens/Um.png");
		case "img2":
			return ("/imagens/Dois.png");
		case "img3":
			return ("/imagens/Tres.png");
		case "img4":
			return ("/imagens/Quatro.png");
		case "img5":
			return ("/imagens/Cinco.png");
		case "img6":
			return ("/imagens/Seis.png");
		case "img7":
			return ("/imagens/Sete.png");
		case "img8":
			return ("/imagens/Oito.png");
		case "img9":
			return ("/imagens/Nove.png");
		case "img10":
			return ("/imagens/Dez.png");
		case "imgBck":
			return ("/imagens/Back.png");
		//Pokemon:
		case "1":
			return ("/imagens/Pokemons/Licktung.png");
		case "2":
			return ("/imagens/Pokemons/Pancham.png");
		case "4":
			return ("/imagens/Pokemons/Pangoro.jpg");
		case "5":
			return ("/imagens/Pokemons/Lickilicky.png");
		case "6":
			return ("/imagens/Pokemons/Dewpider.png");
		case "7":
			return ("/imagens/Pokemons/Lapras.png");
		case "8":
			return ("/imagens/Pokemons/Snorlax.png");
		case "9":
			return ("/imagens/Pokemons/Hippopotas.png");
		case "10":
			return ("/imagens/Pokemons/Onix.png");
		case "11":
			return ("/imagens/Pokemons/Throh.png");
		//Energia:
		case "3":
			return ("/imagens/Energias/Incolor.png");
		case "12":
			return ("/imagens/Energias/Water.png");
		case "13":
			return ("/imagens/Energias/Fighting.png");
		//Treinadores:
		case "14":
			return ("/imagens/Treinadores/Hop.png");
		case "15":
		return ("/imagens/Treinadores/HyperPotion.png");
		default:
			throw new IllegalArgumentException("Invalid image Id");
		}
	}


	

	public ImageView createImage(String imgId) {
		Image img = images.get(imgId);
		
		if (img == null) {
//			img = new Image(id2File(imgId));
			img = new Image(getClass().getResourceAsStream(id2File(imgId)),1000,500,true,true);
			images.put(imgId, img);

		}

		ImageView imgv = new ImageView(img);
		return imgv;
	}

}
