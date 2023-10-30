import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();
        
        Human ivan = new Human("Иван", Gender.Male, LocalDate.of(1919, 12, 12));
        Human elena = new Human("Елена", Gender.Female, LocalDate.of(1920, 1, 23));
        tree.addMembers(ivan);
        tree.addMembers(elena);
        
        tree.setWedding(ivan, elena);
        
        Human petya = new Human("Петя", Gender.Male, LocalDate.of(1940, 5, 20), ivan, elena);
        Human olya = new Human("Оля", Gender.Female, LocalDate.of(1940, 7, 8), ivan, elena);
        tree.addMembers(petya);
        tree.addMembers(olya);
        
        Human vera = new Human("Вера", Gender.Female, LocalDate.of(1899, 5, 8));
        vera.addChild(ivan);
        tree.addMembers(vera);

        FileIO.writeToFile("family_tree.dat", tree);

        FamilyTree loadedTree = (FamilyTree) FileIO.readFromFile("family_tree.dat");
        
        System.out.println(loadedTree.getInfo());
    }
}
