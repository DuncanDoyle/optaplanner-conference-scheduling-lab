package org.optaplanner.training.conference.app;

import java.io.File;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.config.solver.termination.TerminationConfig;
import org.optaplanner.training.conference.domain.ConferenceSolution;
import org.optaplanner.training.conference.persistence.ConferenceSchedulingXlsxFileIO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConferenceSchedulingApp {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ConferenceSchedulingApp.class);

    public static final String SOLVER_CONFIG = "org/optaplanner/training/conference/solver/conferenceSchedulingSolverConfig.xml";

    public static final String DATA_DIR_NAME = "conferencescheduling";

    public static void main(String[] args) {
        
        //Create the SolverFactory
        
        File inputSolutionFileOne = new File("data/conferencescheduling/unsolved/18talks-6timeslots-5rooms.xlsx");
        

        ConferenceSchedulingXlsxFileIO fileIO = new ConferenceSchedulingXlsxFileIO();
        ConferenceSolution problemOne = fileIO.read(inputSolutionFileOne);
        
        //Create the Solver
        
        
        //Solve the problem
        ConferenceSolution solutionOne = null;
        
        File outputSolutionFileOne = new File("data/conferencescheduling/solved/18talks-6timeslots-5rooms.xlsx");
        fileIO.write(solutionOne, outputSolutionFileOne);
    
    }

}
