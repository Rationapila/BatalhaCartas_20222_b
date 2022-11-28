package poo.gui;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import poo.modelo.Game;
import poo.modelo.GameEvent;
import poo.modelo.GameListener;
import poo.modelo.ImageFactory;

public class GameWindow extends Application implements GameListener {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		Game.getInstance().addGameListener(this);

		primaryStage.setTitle("Batalha de Cartas");

		Group root = new Group();

        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab("Jogador 1");
        Tab tab2 = new Tab("Jogador 2");
        Tab tab3 = new Tab("Mesa");
        //Tab tab4 = new Tab("Mesa Jogador 2");

        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(tab2);
        tabPane.getTabs().add(tab3);

		// MAOS E CAMPO DE JOGO
		// --------------------------------------------------------------
		GridPane grid1 = new GridPane();
		grid1.setAlignment(Pos.CENTER);
		grid1.setHgap(10);
		grid1.setVgap(10);
		grid1.setPadding(new Insets(25, 25, 25, 25));

		DeckView deckJ1 = new DeckView(1);
		ScrollPane sd1 = new ScrollPane();
		sd1.setPrefSize(1000, 180);
		sd1.setFitToWidth(true);
		sd1.setFitToHeight(true);
		sd1.setContent(deckJ1);
		grid1.add(sd1, 0, 0);



		GridPane grid2 = new GridPane();
		grid2.setAlignment(Pos.CENTER);
		grid2.setHgap(10);
		grid2.setVgap(10);
		grid2.setPadding(new Insets(25, 25, 25, 25));

		
		DeckView deckJ2 = new DeckView(2);
		ScrollPane sd2 = new ScrollPane();
		sd2.setPrefSize(1000, 180);
		sd2.setFitToWidth(true);
		sd2.setFitToHeight(true);
		sd2.setContent(deckJ2);
		grid2.add(sd2, 0, 0);

	
		GridPane grid3 = new GridPane();
		grid3.setAlignment(Pos.CENTER);
		grid3.setHgap(10);
		grid3.setVgap(10);
		grid3.setPadding(new Insets(25, 25, 25, 25));

		
		DeckView zonaPrincipalJ1 = new DeckView(-3);
		ScrollPane sdR1 = new ScrollPane();
		sdR1.setPrefSize(800, 180);
		sdR1.setFitToWidth(true);
		sdR1.setFitToHeight(true);
		sdR1.setContent(zonaPrincipalJ1);
		grid3.add(sdR1, 0, 1);

		DeckView zonaPrincipalJ2 = new DeckView(-4);
		ScrollPane sdR2 = new ScrollPane();
		sdR2.setPrefSize(800, 180);
		sdR2.setFitToWidth(true);
		sdR2.setFitToHeight(true);
		sdR2.setContent(zonaPrincipalJ2);
		grid3.add(sdR2, 0, 3);

		DeckView mesaJ1 = new DeckView(-1);
		ScrollPane sdM1 = new ScrollPane();
		sdM1.setPrefSize(800, 180);
		sdM1.setFitToWidth(true);
		sdM1.setFitToHeight(true);
		sdM1.setContent(mesaJ1);
		grid3.add(sdM1, 0, 0);

		DeckView mesaJ2 = new DeckView(-2);
		ScrollPane sdM2 = new ScrollPane();
		sdM2.setPrefSize(800, 180);
		sdM2.setFitToWidth(true);
		sdM2.setFitToHeight(true);
		sdM2.setContent(mesaJ2);
		grid3.add(sdM2, 0, 4);

		PlacarView placar = new PlacarView();
		grid3.add(placar, 0, 2);
		// --------------------------------------------------------------
		/* 
		PlacarView placar = new PlacarView();
		grid3.add(placar, 0, 1);
		*/

		/* 
		Button butClean = new Button("Clean");
		grid3.add(butClean, 1, 1);
		butClean.setOnAction(e -> Game.getInstance().removeSelected());
		*/

		// BOTOES DE COMANDO
		// --------------------------------------------------------------
		Button bancoJ1 = new Button("Colocar na reserva");
		grid1.add(bancoJ1, 0, 1);
		bancoJ1.setOnAction(e -> Game.getInstance().colocaReservaJ1());
		

		Button bancoJ2 = new Button("Colocar na reserva");
		grid2.add(bancoJ2, 0, 1);
		bancoJ2.setOnAction(e -> Game.getInstance().colocaReservaJ2());

		Button zonaJ1 = new Button("Zona principal");
		grid1.add(zonaJ1, 0, 2);
		zonaJ1.setOnAction(e -> Game.getInstance().colocaZonaJ1());

		Button zonaJ2 = new Button("Zona principal");
		grid2.add(zonaJ2, 0, 2);
		zonaJ2.setOnAction(e -> Game.getInstance().colocaZonaJ2());

		Button readJ1 = new Button("Ver carta");
		grid1.add(readJ1, 0, 3);
		readJ1.setOnAction(e -> Game.getInstance().lerCarta(1));

		Button preparacaoJ1 = new Button("Preparação Concluída");
		grid1.add( preparacaoJ1, 0, 5);
		preparacaoJ1.setOnAction(e -> Game.getInstance().preparacao(1));

		Button preparacaoJ2 = new Button("Preparação Concluída");
		grid2.add( preparacaoJ2, 0, 5);
		preparacaoJ2.setOnAction(e -> Game.getInstance().preparacao(2));

		Button readJ2 = new Button("Ver carta");
		grid2.add(readJ2, 0, 3);
		readJ2.setOnAction(e -> Game.getInstance().lerCarta(2));

		Button readM1 = new Button("Ver carta");
		grid3.add(readM1, 1, 0);
		readM1.setOnAction(e -> Game.getInstance().lerCarta(3));

		Button readM2 = new Button("Ver carta");
		grid3.add(readM2, 1, 4);
		readM2.setOnAction(e -> Game.getInstance().lerCarta(4));

		Button readZ1 = new Button("Ver carta");
		grid3.add(readZ1, 0, 1);
		readZ1.setOnAction(e -> Game.getInstance().lerCarta(5));

		Button readZ2 = new Button("Ver carta");
		grid3.add(readZ2, 0, 3);
		readZ2.setOnAction(e -> Game.getInstance().lerCarta(6));

		Button ataqueZ1 = new Button ("Ataque 1");
		grid3.add(ataqueZ1, 1, 1);
		ataqueZ1.setOnAction(e -> Game.getInstance().ataqueZ1(1));

		Button ataqueZ2 = new Button ("Ataque 1");
		grid3.add(ataqueZ2, 1, 3);
			ataqueZ2.setOnAction(e -> Game.getInstance().ataqueZ2(1));

		/* 
		Button passavezJ1 = new Button ("Passa vez");
		grid1.add(passavezJ1, 0, 6);
		if (Game.getInstance().getVez() == 1){
			passavezJ1.setOnAction(e -> Game.getInstance().nextPlayer());
		}
		*/
		Button colocaZonaPrincipalReservaJ1 = new Button ("Coloca na zona");
		grid3.add(colocaZonaPrincipalReservaJ1, 2, 0);
		colocaZonaPrincipalReservaJ1.setOnAction(e -> Game.getInstance().colocaZonaReservaJ1());

		Button colocaZonaPrincipalReservaJ2 = new Button ("Coloca na zona");
		grid3.add(colocaZonaPrincipalReservaJ2, 2, 5);
		colocaZonaPrincipalReservaJ2.setOnAction(e -> Game.getInstance().colocaZonaReservaJ2());

		Button energiaZonaJ1 = new Button ("Energia: Zona principal");
		grid1.add(energiaZonaJ1, 6, 0);
		energiaZonaJ1.setOnAction(e -> Game.getInstance().usaEnergiaJ1(1));

		Button energiaZonaJ2 = new Button ("Energia: Zona principal");
		grid2.add(energiaZonaJ2, 6, 0);
		energiaZonaJ2.setOnAction(e -> Game.getInstance().usaEnergiaJ2(1));

		/* 
		Button energiaReservaJ1 = new Button ("Energia: Reserva");
		grid1.add(energiaReservaJ1, 6, 1);
		energiaReservaJ1.setOnAction(e -> Game.getInstance().usaEnergiaJ2(2));
		*/
		
		Game.getInstance().playComeco();

		//Button VidaPokemon1 = new Button (String.valueOf(Game.getInstance().getVidaZ1()));
		//grid3.add(VidaPokemon1, 0, 1);
		

		//Button butDrawP1 = new Button("Draw");
		//grid1.add(butDrawP1, 0, 4);
		//butDrawP1.setOnAction(e -> Game.getInstance().drawCardP1());

		//Button butDrawP2 = new Button("Draw");
		//grid2.add(butDrawP2, 0, 4);
		//butDrawP2.setOnAction(e -> Game.getInstance().drawCardP2());
		// --------------------------------------------------------------
		

		tab1.setContent(grid1);
        tab2.setContent(grid2);
        tab3.setContent(grid3);


		root.getChildren().add(tabPane);
		
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
	

	@Override
	public void notify(GameEvent eg) {
		Alert alert;
		if (eg == null) return;
		if (eg.getTarget() == GameEvent.Target.GWIN) {
			switch (eg.getAction()) {
			case INVPLAY:
				alert = new Alert(AlertType.WARNING);
				alert.setTitle("Atenção !!");
				alert.setHeaderText("Jogada inválida!!");
				alert.setContentText("Era a vez do jogador " + eg.getArg());
				alert.showAndWait();
				break;
			case MUSTCLEAN:
				alert = new Alert(AlertType.WARNING);
				alert.setTitle("Atenção !!");
				alert.setHeaderText(null);
				alert.setContentText("Utilize o botao \"Clean\"");
				alert.showAndWait();
				break;
			case ENDGAME:
				String text = "Fim de Jogo !!\n";
				if (Game.getInstance().getPontosJ1() >= 6) {
					text += "O jogador 1 ganhou !! :-)";
				}
				if (Game.getInstance().getPontosJ2() >= 6){
					text += "O jogador 2 ganhou !! :-)";
				}
				alert = new Alert(AlertType.WARNING);
				alert.setTitle("Parabens !!");
				alert.setHeaderText(null);
				alert.setContentText(text);
				alert.showAndWait();
				break;
			case NOCARDS:
			String texto = "Não há mais cartas em seu deck.";
			
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("Cuidado!");
			alert.setHeaderText(null);
			alert.setContentText(texto);
			alert.showAndWait();
			break;
			case ZONETAKEN:
			String textZone = "Ja há um Pokémon em sua zona principal.";
			alert = new Alert(AlertType.WARNING);
			alert.setTitle("Cuidado!");
			alert.setHeaderText(null);
			alert.setContentText(textZone);
			alert.showAndWait();
			break;
			case READCARDJ1:
			alert = new Alert(AlertType.INFORMATION);
			alert.getButtonTypes().set(0, new ButtonType("OK", ButtonData.LEFT));
			String cartaIdJ1 = Game.getInstance().getIdCarta(1);
			ImageView imageViewJ1 = ImageFactory.getInstance().createImage(cartaIdJ1);
			imageViewJ1.setPreserveRatio(true);
			imageViewJ1.setSmooth(true);
			alert.setGraphic(imageViewJ1);
			alert.setTitle("Leitura de Carta");
			alert.setHeaderText(null);
			alert.showAndWait();
			break;
			case READCARDJ2:
			alert = new Alert(AlertType.INFORMATION);
			alert.getButtonTypes().set(0, new ButtonType("OK", ButtonData.LEFT));
			String cartaIdJ2 = Game.getInstance().getIdCarta(2);
			ImageView imageViewJ2 = ImageFactory.getInstance().createImage(cartaIdJ2);
			imageViewJ2.setPreserveRatio(true);
			imageViewJ2.setSmooth(false);
			alert.setGraphic(imageViewJ2);
			alert.setTitle("Leitura de Carta");
			alert.setHeaderText(null);
			alert.showAndWait();
			break;
			case READCARDM1:
			alert = new Alert(AlertType.INFORMATION);
			alert.getButtonTypes().set(0, new ButtonType("OK", ButtonData.LEFT));
			String cartaIdM1 = Game.getInstance().getIdCarta(3);
			ImageView imageViewM1 = ImageFactory.getInstance().createImage(cartaIdM1);
			imageViewM1.setPreserveRatio(true);
			imageViewM1.setSmooth(false);
			alert.setGraphic(imageViewM1);
			alert.setTitle("Leitura de Carta");
			alert.setHeaderText(null);
			alert.showAndWait();
			break;
			case READCARDM2:
			alert = new Alert(AlertType.INFORMATION);
			alert.getButtonTypes().set(0, new ButtonType("OK", ButtonData.LEFT));
			String cartaIdM2 = Game.getInstance().getIdCarta(4);
			ImageView imageViewM2 = ImageFactory.getInstance().createImage(cartaIdM2);
			imageViewM2.setPreserveRatio(true);
			imageViewM2.setSmooth(false);
			alert.setGraphic(imageViewM2);
			alert.setTitle("Leitura de Carta");
			alert.setHeaderText(null);
			alert.showAndWait();
			break;
			case READCARDZ1:
			alert = new Alert(AlertType.INFORMATION);
			alert.getButtonTypes().set(0, new ButtonType("OK", ButtonData.LEFT));
			String cartaIdZ1 = Game.getInstance().getIdCarta(5);
			ImageView imageViewZ1 = ImageFactory.getInstance().createImage(cartaIdZ1);
			imageViewZ1.setPreserveRatio(true);
			imageViewZ1.setSmooth(false);
			alert.setGraphic(imageViewZ1);
			alert.setTitle("Leitura de Carta");
			alert.setHeaderText(null);
			alert.showAndWait();
			break;
			case READCARDZ2:
			alert = new Alert(AlertType.INFORMATION);
			alert.getButtonTypes().set(0, new ButtonType("OK", ButtonData.LEFT));
			String cartaIdZ2 = Game.getInstance().getIdCarta(6);
			ImageView imageViewZ2 = ImageFactory.getInstance().createImage(cartaIdZ2);
			imageViewZ2.setPreserveRatio(true);
			imageViewZ2.setSmooth(false);
			alert.setGraphic(imageViewZ2);
			alert.setTitle("Leitura de Carta");
			alert.setHeaderText(null);
			alert.showAndWait();
			break;
			case PREPARATION:
			String textopreparação = "Fim da fase de preparações.\n Jogador 1 começa.";
			alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Final de preparações");
			alert.setHeaderText(null);
			alert.setContentText(textopreparação);
			alert.showAndWait();
			break;
			case NEXTPLAYER:
			String textonextplayer = "Turno encerrado, vez do jogador " + Game.getInstance().getVez();
			alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Próximo turno");
			alert.setHeaderText(null);
			alert.setContentText(textonextplayer);
			alert.showAndWait();
			break;
			case REMOVESEL:
				// Esse evento não vem para cá
			}
		}
	}

}
