package movement;

/**
 *
 */
public class KinematicFlee {
     private Kinematic character;
    private Kinematic target;
    private double maxSpeed;

    public KinematicFlee() {
    }

    public KinematicFlee(Kinematic character, Kinematic target, double maxSpeed) {
        this.character = character;
        this.target = target;
        this.maxSpeed = maxSpeed;
    }

    public Kinematic getCharacter() {
        return character;
    }

    public void setCharacter(Kinematic character) {
        this.character = character;
    }

    public Kinematic getTarget() {
        return target;
    }

    public void setTarget(Kinematic target) {
        this.target = target;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public KinematicSteeringOutput getSteering() {
        KinematicSteeringOutput steering = new KinematicSteeringOutput();

        steering.setVelocity(Vector.sub(character.getPosition(), target.getPosition()));

        
        steering.setVelocity(Vector.normalize(steering.getVelocity()));
        steering.setVelocity(Vector.mul(steering.getVelocity(), maxSpeed));

        character.setOrientation(Kinematic.getNewOrientation(character.getOrientation(), steering.getVelocity()));

        steering.setRotation(0);
        return steering;
    }
}
