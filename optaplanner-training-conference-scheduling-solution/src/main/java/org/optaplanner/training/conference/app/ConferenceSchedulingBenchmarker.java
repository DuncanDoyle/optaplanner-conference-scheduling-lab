package org.optaplanner.training.conference.app;

import java.io.File;

import org.optaplanner.benchmark.api.PlannerBenchmark;
import org.optaplanner.benchmark.api.PlannerBenchmarkFactory;
import org.optaplanner.core.api.solver.SolverFactory;
import org.optaplanner.core.config.solver.termination.TerminationConfig;
import org.optaplanner.training.conference.domain.ConferenceSolution;
import org.optaplanner.training.conference.persistence.ConferenceSchedulingXlsxFileIO;

public class ConferenceSchedulingBenchmarker {

    
    public static final String SOLVER_CONFIG = "org/optaplanner/training/conference/solver/conferenceSchedulingSolverConfig.xml";
    
    public static void main(String[] args) {
        
        SolverFactory<ConferenceSolution> solverFactory = SolverFactory.createFromXmlResource(SOLVER_CONFIG);

        File inputSolutionFileOne = new File("data/conferencescheduling/unsolved/18talks-6timeslots-5rooms.xlsx");
        File inputSolutionFileTwo = new File("data/conferencescheduling/unsolved/36talks-12timeslots-5rooms.xlsx");

        ConferenceSchedulingXlsxFileIO fileIO = new ConferenceSchedulingXlsxFileIO();
       
        ConferenceSolution problemOne = fileIO.read(inputSolutionFileOne);
        ConferenceSolution problemTwo = fileIO.read(inputSolutionFileTwo);

        PlannerBenchmarkFactory benchmarkerFactory = PlannerBenchmarkFactory.createFromSolverFactory(solverFactory);
        TerminationConfig terminationConfig = new TerminationConfig();
        terminationConfig.setSecondsSpentLimit(30L);
        benchmarkerFactory.getPlannerBenchmarkConfig().getInheritedSolverBenchmarkConfig().getSolverConfig().setTerminationConfig(terminationConfig);
        PlannerBenchmark benchmarker = benchmarkerFactory.buildPlannerBenchmark(problemOne, problemTwo);
        benchmarker.benchmark();
    }
    
}
