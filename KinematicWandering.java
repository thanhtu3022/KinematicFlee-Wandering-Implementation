package movement;

/**
 *
 */
public class KinematicWander {

    private Kinematic character;
    private double maxSpeed;
    private double maxRotation;

    public KinematicWander() {
    }

    public KinematicWander(Kinematic character, double maxSpeed, double maxRotation) {
        this.character = character;
        this.maxSpeed = maxSpeed;
        this.maxRotation = maxRotation;
    }

    public Kinematic getCharacter() {
        return character;
    }

    public void setCharacter(Kinematic character) {
        this.character = character;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getMaxRotation() {
        return maxRotation;
    }

    public void setMaxRotation(double maxRotation) {
        this.maxRotation = maxRotation;
    }


    public KinematicSteeringOutput getSteering() {
        KinematicSteeringOutput streering = new KinematicSteeringOutput();
        streering.setVelocity(Vector.asVector(character.getOrientation()).mul(maxSpeed));
        streering.setRotation(Vector.randomBinommial() * maxRotation);
        return streering;
    }
}
