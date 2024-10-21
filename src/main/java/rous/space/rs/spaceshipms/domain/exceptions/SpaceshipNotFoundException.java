package rous.space.rs.spaceshipms.domain.exceptions;

public class SpaceshipNotFoundException extends RuntimeException{

    public SpaceshipNotFoundException (String message){
        super(message);
    }
}
