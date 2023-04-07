package cscd212classes.lab2;
public class Television implements Comparable<Television>{

    public Television(final String make, final String model, final boolean smart, final int screenSize, final int resolution){

        if(make == null || make.isEmpty() || model == null || model.isEmpty() || screenSize < 32 || resolution < 720){
            throw new IllegalArgumentException("Invalid parameter in constructor");
        }

        this.make = make;
        this.model = model;
        this.smart = smart;
        this.screenSize = screenSize;
        this.resolution = resolution;

        if(this.resolution == 2160){
            fourK = true;
        }else{
            fourK = false;
        }
    }

    public Television(final String model, final boolean smart, final int screenSize, final int resolution, final String make){

        this(make, model, smart, screenSize, resolution);

    }

    private final String make;
    private final String model;
    private final boolean fourK;
    private final boolean smart;
    private final int screenSize;
    private final int resolution;


    public int getScreenSize() {
        return screenSize;
    }
    public int getResolution() {
        return resolution;
    }
    public String getMake() {
        return make;
    }
    public String getModel() {
        return model;
    }

    @Override
    public String toString() {

        String description = "";

        description += getMake() + "-"
                    + getModel()+ ", "
                    + getScreenSize() + " inch ";

        if(smart == true){
            description += "smart ";
        }

        description += "tv with ";

        if(fourK == true){
            description += "4K resolution";
        }else{
            description += getResolution() + " resolution";
        }
        return description;
    }

    @Override //maybe done, ask in class
    public boolean equals(final Object o){

        boolean equalsMake, equalsModel, equalsSmart, equalsScreenSize, equalsResolution;

        if(o == this){
            return true;
        }else if(o == null){
            return false;
        }else if(!(o instanceof Television)){
            return false;
        }

        Television tel = (Television)o;

        equalsMake = (this.getMake()).equals(tel.getMake());
        equalsModel = (this.getModel()).equals(tel.getModel());
        equalsScreenSize = ((int)(this.getScreenSize()) == (int)(tel.getScreenSize()));
        equalsResolution = ((int)(this.getResolution()) == (int)(tel.getResolution()));
        equalsSmart = this.smart == tel.smart;

        return(equalsMake && equalsModel && equalsSmart && equalsScreenSize && equalsResolution);
    }

    @Override
    public int hashCode(){
        return make.hashCode()
                + model.hashCode()
                + resolution
                + Boolean.hashCode(smart)
                + Boolean.hashCode(fourK);
    }

    @Override
    public int compareTo(final Television another){

        if(another == null){
            throw new IllegalArgumentException("null parameter in the compareTo method");
        }

        if(this.getMake().compareTo(another.getMake()) == 0){
            if(this.getModel().compareTo(another.getModel()) == 0){
                return this.getScreenSize() - another.getScreenSize();
            }else{
                return this.getModel().compareTo(another.getModel());
            }

        }
        return this.getMake().compareTo(another.getMake());
    }

}
