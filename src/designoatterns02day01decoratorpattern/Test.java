package designoatterns02day01decoratorpattern;

/**
 *
 * @author 1999k
 */
public class Test {

    public static void main(String[] args) {

//        VanilaIceCream vanilaIceCream = new VanilaIceCream(); // ice cream kiyanne abstarct class ekk nisa kelinma object hadanan bari unata eyage childla wana normal class ekata object eka hadnana puluwan
//        System.out.println(vanilaIceCream.getPrice());
//
//        ChocalteSauce chocalteSauce = new ChocalteSauce(vanilaIceCream);
//        System.out.println(chocalteSauce.getPrice());
//mehema karana eka thama lassnama mokda mehema karanna puluwan chocalte source kianneth ice creamm ekk nisama apita IceCream kiyan parent type eken dekma thyaganna puluwan meka thama lassana widiya
        IceCream ic = new VanilaIceCream();
        ic = new ChocalteSauce(ic);
        System.out.println(ic.getPrice());                   // mekedi baluwama penawa mulin ice cream eka aran eka choclate source kiyana eken wrap karala wage wadak thama me karala thinne
        System.out.println(ic.getDescription());
        System.out.println("");

        IceCream ic2 = new StrawberyIceCream();
        ic2 = new ChocalteSauce(ic2);
        ic2 = new CashewNuts(ic2);   // mekedi ice cream eka aran choclate sause dala passe aye cashe nut walin wrap karala
        System.out.println(ic2.getPrice());
        System.out.println(ic2.getDescription());
        System.out.println("");

        IceCream ic3 = new VanilaIceCream();
        System.out.println(ic3.getPrice());   // mekedi kisima wrap ekak na
        System.out.println(ic3.getDescription());
        System.out.println("");

    }

}

abstract class IceCream { // Component

    // apita meke abstarct methods witharak thina nisa apita onen meka interface ekak unth karanna puluwan
    
    public abstract double getPrice(); // me metod eka abstract thiyanan hethuwa thama kauru hari ice cream ekka price eka ahuwata apita ice cream eke price ekk kiyanna ba mokda eka wargayak ekka kiyanan one e nisa meka abstract karala meyage subchild la wena ayata price eka denan puluwan wenan hadala thinne

    public abstract String getDescription();
}

class VanilaIceCream extends IceCream { // Sub Component

    @Override
    public double getPrice() { // ice cream kiyana ekata hariyata price ekk kiyanan bari unata vanila ice cream kiyala specify karama apita price ekk denna puluwan e nisa parentgen overide una method eken apita meyage price eka kiyanan puluwan
        return 50;
    }

    @Override
    public String getDescription() {
        return "Vanila Ice Cream";
    }

}

class StrawberyIceCream extends IceCream {

    @Override
    public double getPrice() {
        return 80;
    }

    @Override
    public String getDescription() {
        return "Strawbery Ice Cream";
    }

}

abstract class IceCreamDecorator extends IceCream { // Decorator //Ic cream eka extend karanna hethuwa ice cream ekata decoratoer eka dmmata passe eka ice cream ekk wenawa e kiyanne Decorator IS_A component

    private final IceCream iceCream; // decorator ekata ice cream ekak thnawa kiyanan decorator Has_A component // me class eka athule witharak use karana nisa private karana atha final karanne ice cream ekata decorator ekak dammata passe aye ice cream eka ain karanne nane ekai mehema karanne e kiyanne decorator eka ice cream ekata dmmata passe aye wen karanna ba kiyana eka

    public IceCreamDecorator(IceCream iceCream) { // api methana constructor eke meka hadanne ethakota api decorator ekak hadana hama welema ice cream ekk one kiyala illanwa, setter ekak dmmata ema wenen na ethakota meken object ekk hadaddima ice cream(Component eka) ekk denna one mokda decorator eka dnna nm ice cream ekka thinnama one nisa, api meka super eke danna hethuwa thama ethakota meya ge childla okkotama meka overide karagannama wenawa 
        this.iceCream = iceCream;
    }

    // api ice cream kiyana eke hadapu abstract method eka meke overide karanna one wenne na mokda meka abstract ekak nisa abstract class ekak athule abstract ethod thinna puluwan nisa
    @Override
    public double getPrice() { // api mulinma meka overide nokarata ape scenario ekata anuwa apita wenawa decorator eka add karata passe ice cream price eka denna ethkota apita wenawa ice cream eke price eka ganna , child type eke edan super call karala price eka illuwama meka overide karala price eka return nokakranm wade ganan ba mokda kelinma apita access karanna ba super type eka gawa thama ice cream eka thinne e nisa meyawa overide karan meyagen price eka aran denne apita onenm super call nokara variable eka access karanan thibab eth scenario ekedi ehema karama wade kathai ekai mehema akranne
        return iceCream.getPrice();
    }

    @Override
    public String getDescription() {
        return iceCream.getDescription() + " with";
    }

}

class ChocalteSauce extends IceCreamDecorator { // Sub Decorator

    public ChocalteSauce(IceCream iceCream) {
        super(iceCream);
    }

    // mekedi apita ice cream eke abstract method overide karanna one mokda meka normal class ekak
    @Override
    public double getPrice() {
        return super.getPrice() + 10;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Choclate Sause ";
    }

}

class CashewNuts extends IceCreamDecorator {

    public CashewNuts(IceCream iceCream) {
        super(iceCream);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + 25;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " Cashew Nuts ";
    }
}

// aluthen ice cream haduwath decrators haduwath apita aluthen class eka hadnawa arenna dnata thina exsiting codes wala wenasak karanna one na ekai meke speciality eak
