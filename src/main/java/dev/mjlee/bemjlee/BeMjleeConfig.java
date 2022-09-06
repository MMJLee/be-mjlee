package dev.mjlee.bemjlee;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;

import dev.mjlee.bemjlee.Player.Player;
import dev.mjlee.bemjlee.Player.PlayerRepository;
import dev.mjlee.bemjlee.Project.Project;
import dev.mjlee.bemjlee.Project.ProjectRepository;
import dev.mjlee.bemjlee.Statement.Statement;
import dev.mjlee.bemjlee.Statement.StatementRepository;

@Configuration
public class BeMjleeConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProjectRepository projectRepository, StatementRepository statementRepository,
            PlayerRepository playerRepository) {
        return args -> {
            loadStatements(statementRepository);
            loadProjects(projectRepository);
            loadPlayers(playerRepository);
        };
    }

    private void loadStatements(StatementRepository statementRepository) throws IOException {
        final URL urlStatements = this.getClass().getClassLoader()
                .getResource("StatementDatabase.csv");
        if (urlStatements == null) {
            System.out.println("resource not found");
            throw new IOException("resource not found");
        }
        try (CSVReader reader = new CSVReader(new InputStreamReader(urlStatements.openStream()))) {
            List<Statement> beans = new CsvToBeanBuilder<Statement>(reader).withType(Statement.class)
                    .build()
                    .parse();
            for (Statement statement : beans) {
                statementRepository.save(statement);
            }
        }
    }

    private void loadProjects(ProjectRepository projectRepository) throws IOException {
        final URL urlProjects = this.getClass().getClassLoader()
                .getResource("ProjectDatabase.csv");
        if (urlProjects == null) {
            System.out.println("resource not found");
            throw new IOException("resource not found");
        }
        try (CSVReader reader = new CSVReader(new InputStreamReader(urlProjects.openStream()))) {
            List<Project> beans = new CsvToBeanBuilder<Project>(reader).withType(Project.class)
                    .build()
                    .parse();
            for (Project project : beans) {
                projectRepository.save(project);
            }
        }
    }

    private void loadPlayers(PlayerRepository playerRepository) throws IOException {
        final URL urlPlayer = this.getClass().getClassLoader()
                .getResource("PlayerDatabase.csv");
        if (urlPlayer == null) {
            System.out.println("resource not found");
            throw new IOException("resource not found");
        }
        try (CSVReader reader = new CSVReader(new InputStreamReader(urlPlayer.openStream()))) {
            List<Player> beans = new CsvToBeanBuilder<Player>(reader).withType(Player.class)
                    .build()
                    .parse();
            for (Player player : beans) {
                playerRepository.save(player);
            }
        }
    }
}