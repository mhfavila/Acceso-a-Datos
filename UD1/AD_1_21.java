import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/**
 * 
 * @author Favila
 *
 */
public class AD_1_21 {

	public static void main(String[] args) {

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();

			Document document = builder.parse(new File(
					"C:\\Users\\favil\\OneDrive\\Documents\\GitHub\\2DAM-REP\\ACCESO A DATOS\\T_1\\src\\pruebaCodigosApuntes\\Asignaturas.xml"));
			document.getDocumentElement().normalize();

			System.out.printf("Raiz del documento" + document.getDocumentElement().getNodeName());
			NodeList asignaturas = document.getElementsByTagName("asignatura");
			System.out.printf("Numero de nodos de la asignatura: " + asignaturas.getLength()+"\n");

			for (int i = 0; i < asignaturas.getLength(); i++) {
				Node asig = asignaturas.item(i);
				if (asig.getNodeType() == Node.ELEMENT_NODE) {
					Element elemento = (Element) asig;
					System.out.print("Nombre de la Asignatura: "+elemento.getAttribute("nombre").indent(i));
					//System.out.println("Nombre: " + elemento.getElementsByTagName("asignatura nombre").item(0).getTextContent());

					System.out.println(" *horas: " + elemento.getElementsByTagName("horas").item(0).getTextContent());

					System.out.println(
							" *profesor: " + elemento.getElementsByTagName("profesor").item(0).getTextContent());

					

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
