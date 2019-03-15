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
        
        /*
         * Task: Run the BenchMarker.
         * - Create a PlannerBenchmarkerFactory from a SolverFactory
         * - Load 2 problems
         * - Build the PlannerBenchmark using the factory and the 2 problems
         * - Run the benchmarker.
         * - Analyse the output.  
         */
         
        
    }
    
}
