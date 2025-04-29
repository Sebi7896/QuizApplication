package com.sebastian.quizeducativ.model;

import java.util.ArrayList;

public class QuizModels {
    public static QuizModel createSimpleQuiz() {

        ArrayList<QuizQuestion> questions = new ArrayList<>();

        questions.add(new QuizQuestion(
                "What is cultural anthropology?",
                "The study of human societies and cultures",
                "The study of plants and animals",
                "The study of human societies and cultures",
                "The study of human history",
                "The study of languages"
        ));
        questions.add(new QuizQuestion(
                "Which of the following is an example of cultural diversity?",
                "Different languages spoken in a country",
                "Different languages spoken in a country",
                "The same food eaten everywhere",
                "The same clothing worn by all people",
                "Everyone having the same religion"
        ));

        questions.add(new QuizQuestion(
                "Which of the following is a characteristic of ethnocentrism?",
                "Judging another culture by the standards of one's own culture",
                "Judging another culture by the standards of one's own culture",
                "Respecting all cultures equally",
                "Studying a culture objectively",
                "Adapting to different cultural practices"
        ));

        questions.add(new QuizQuestion(
                "What does participant observation involve?",
                "Living among the people being studied and participating in their daily life",
                "Studying historical artifacts",
                "Observing people from a distance",
                "Living among the people being studied and participating in their daily life",
                "Interviewing only community leaders"
        ));
        questions.add(new QuizQuestion(
                "Which of the following is a cultural universal?",
                "Marriage",
                "Language",
                "Music",
                "All of the above",
                "Marriage"
        ));

//        questions.add(new QuizQuestion(
//                "What is the study of human societies and their development called?",
//                "Sociology",
//                "Cultural anthropology",
//                "Psychology",
//                "History",
//                "Cultural anthropology"
//        ));
//        questions.add(new QuizQuestion(
//                "What is the main goal of cultural anthropology?",
//                "To understand human behavior in cultural contexts",
//                "To learn about ancient civilizations",
//                "To study how the brain works",
//                "To observe animal behavior",
//                "To understand human behavior in cultural contexts"
//        ));
//
//        questions.add(new QuizQuestion(
//                "Which method is commonly used by anthropologists to gather information?",
//                "Interviews and surveys",
//                "Traveling to different countries",
//                "Experimentation in a lab",
//                "Reading books",
//                "Interviews and surveys"
//        ));
//
//        questions.add(new QuizQuestion(
//                "What is an example of a cultural practice?",
//                "Celebrating a national holiday",
//                "Breathing air",
//                "Walking",
//                "Eating food",
//                "Celebrating a national holiday"
//        ));
//
//        questions.add(new QuizQuestion(
//                "Which of these is part of a society's culture?",
//                "Music",
//                "Clothing",
//                "Beliefs",
//                "All of the above",
//                "Dancing"
//        ));
//
//        questions.add(new QuizQuestion(
//                "What does 'cultural relativism' suggest?",
//                "All cultures should be judged by the same standards",
//                "Each culture should be understood on its own terms",
//                "Some cultures are superior to others",
//                "Cultural diversity is not important",
//                "Each culture should be understood on its own terms"
//        ));
//
//        questions.add(new QuizQuestion(
//                "Which of the following best defines 'culture'?",
//                "A shared set of beliefs, values, and practices in a society",
//                "The study of ancient artifacts",
//                "The language spoken by a community",
//                "The physical appearance of individuals",
//                "A shared set of beliefs, values, and practices in a society"
//        ));

        return new QuizModel("Easy Quiz",5000,questions);
    }

    public static QuizModel createMediumQuiz() {

        ArrayList<QuizQuestion> questions = new ArrayList<>();

        questions.add(new QuizQuestion(
                "What is the primary focus of cultural anthropology?",
                "To study how culture influences human behavior",
                "To study how culture influences human behavior",
                "To study physical characteristics of human evolution",
                "To study human languages",
                "To study the biology of humans"
        ));
        questions.add(new QuizQuestion(
                "Which of the following methods is commonly used by cultural anthropologists to study societies?",
                "Ethnography",
                "Genealogical method",
                "Comparative analysis",
                "Experimentation",
                "Ethnography"
        ));
        questions.add(new QuizQuestion(
                "What is the term for a shared cultural belief in a society that is often considered sacred?",
                "Taboo",
                "Taboo",
                "Ritual",
                "Myth",
                "Ideology"
        ));

        questions.add(new QuizQuestion(
                "Which type of kinship system is practiced in societies where descent is traced through the father’s side?",
                "Patrilineal",
                "Patrilineal",
                "Matrilineal",
                "Bilateral",
                "Unilineal"
        ));
        questions.add(new QuizQuestion(
                "Which of the following is a common feature of foraging societies?",
                "Small population size and reliance on hunting and gathering",
                "Large, centralized governments",
                "Small population size and reliance on hunting and gathering",
                "Extensive agriculture and farming",
                "Heavy reliance on trade and commerce"
        ));
        questions.add(new QuizQuestion(
                "What is the term for a social system where individuals inherit social positions and wealth from their parents?",
                "Caste system",
                "Caste system",
                "Class system",
                "Meritocracy",
                "Feudalism"
        ));

        questions.add(new QuizQuestion(
                "In anthropological research, what is participant observation?",
                "The anthropologist participates in the daily life of the people being studied while observing them",
                "The anthropologist surveys people in different cultures",
                "The anthropologist participates in the daily life of the people being studied while observing them",
                "The anthropologist studies artifacts from an ancient civilization",
                "The anthropologist observes people without interacting with them"
        ));

        questions.add(new QuizQuestion(
                "What does the concept of cultural relativism suggest?",
                "All cultures should be judged by the same standards",
                "One culture is superior to others",
                "All cultures should be judged by the same standards",
                "Cultures should be understood in their own context without judgment",
                "Culture should be studied in isolation"
        ));
        questions.add(new QuizQuestion(
                "Which term refers to the study of the relationship between language and culture?",
                "Linguistic anthropology",
                "Sociology",
                "Psychology",
                "Cognitive anthropology",
                "Linguistic anthropology"
        ));
        questions.add(new QuizQuestion(
                "Which of the following is an example of a cultural rite of passage?",
                "A wedding ceremony",
                "The birth of a child",
                "A wedding ceremony",
                "Watching a sports game",
                "Eating dinner with family"
        ));
        questions.add(new QuizQuestion(
                "What does the term 'ethnocentrism' refer to?",
                "The practice of judging another culture by the standards of one’s own culture",
                "The practice of judging another culture by the standards of one’s own culture",
                "The belief that all cultures are equal",
                "The belief in the superiority of one’s own culture",
                "Understanding and respecting other cultures"
        ));
        questions.add(new QuizQuestion(
                "Which concept refers to the idea that humans have evolved to adapt to different environments?",
                "Cultural evolution",
                "Cultural evolution",
                "Biological evolution",
                "Environmental adaptation",
                "Cultural adaptation"
        ));

        questions.add(new QuizQuestion(
                "Which of the following is an example of a structural feature of culture?",
                "The division of labor in society",
                "A specific language spoken in a community",
                "The division of labor in society",
                "A person's individual experiences",
                "The beliefs of a specific individual"
        ));

        questions.add(new QuizQuestion(
                "What is the main difference between a nation and a state in political anthropology?",
                "A nation is a group of people with a shared culture, while a state is a political entity",
                "A nation is a country, while a state is an organization",
                "A state is a group of people with a shared culture, while a nation is a political entity",
                "A nation is a group of people with a shared culture, while a state is a political entity",
                "A state and a nation are the same"
        ));

        questions.add(new QuizQuestion(
                "Which of the following is a primary characteristic of agricultural societies?",
                "Large, permanent settlements and reliance on farming",
                "Nomadic lifestyle with hunting and gathering",
                "Small populations with no permanent settlements",
                "High mobility and dependence on trade",
                "Large, permanent settlements and reliance on farming"
        ));

        return new QuizModel("Medium Quiz",30000, questions);
    }
    public static QuizModel createHardQuiz() {

        ArrayList<QuizQuestion> questions = new ArrayList<>();
        questions.add(new QuizQuestion(
                "The study of how symbols shape and reflect human experience",
                "What does the concept of 'symbolic anthropology' primarily focus on?",
                "The study of how symbols shape and reflect human experience",
                "The study of human biology",
                "The study of human evolutionary development",
                "The analysis of economic structures in societies"
        ));

        questions.add(new QuizQuestion(
                "Which anthropologist is known for developing the concept of 'cultural materialism'?",
                "Marvin Harris",
                "Marvin Harris",
                "Clifford Geertz",
                "Victor Turner",
                "Franz Boas"
        ));

        questions.add(new QuizQuestion(
                "In the context of structuralism, who is associated with the idea of binary oppositions in cultural analysis?",
                "Claude Lévi-Strauss",
                "Michel Foucault",
                "Max Weber",
                "Claude Lévi-Strauss",
                "Émile Durkheim"
        ));

        questions.add(new QuizQuestion(
                "Which anthropologist is associated with the concept of 'the thick description' method of ethnographic writing?",
                "Clifford Geertz",
                "Clifford Geertz",
                "Ruth Benedict",
                "Margaret Mead",
                "Edward Said"
        ));

        questions.add(new QuizQuestion(
                "What does the term 'syncretism' refer to in cultural anthropology?",
                "The blending of different cultural traditions into a new form",
                "The separation of cultural practices",
                "The return to traditional cultural practices",
                "The refusal to accept foreign cultural influences",
                "The blending of different cultural traditions into a new form"
        ));
        questions.add(new QuizQuestion(
                "What is the 'development anthropology' approach concerned with?",
                "The role of culture in economic development and social change",
                "The role of culture in economic development and social change",
                "The study of past human remains",
                "The analysis of language structures",
                "The historical study of empires"
        ));
        questions.add(new QuizQuestion(
                "Which concept in anthropology refers to the tendency for one culture to impose its values on another?",
                "Cultural imperialism",
                "Cultural relativism",
                "Cultural appropriation",
                "Cultural assimilation",
                "Cultural imperialism"
        ));

        questions.add(new QuizQuestion(
                "What is the primary concern of feminist anthropology?",
                "Understanding how gender and power shape cultural norms",
                "Understanding how gender and power shape cultural norms",
                "The study of ancient civilizations",
                "The exploration of human evolution",
                "The cultural significance of economic systems"
        ));
        questions.add(new QuizQuestion(
                "Which of the following best describes 'kinship terminology'?",
                "The system by which societies categorize family relationships",
                "The language used to describe cultural rituals",
                "The classification of foods in different cultures",
                "The system by which societies categorize family relationships",
                "The methods used for social control in different cultures"
        ));

        questions.add(new QuizQuestion(
                "Which theory argues that human behavior and social structures are largely shaped by material conditions?",
                "Marxist anthropology",
                "Marxist anthropology",
                "Functionalist anthropology",
                "Symbolic interactionism",
                "Postmodern anthropology"
        ));

        questions.add(new QuizQuestion(
                "Which concept is associated with the idea that culture is produced through complex systems of symbols, language, and rituals?",
                "Cultural constructivism",
                "Cultural materialism",
                "Cultural constructivism",
                "Structuralism",
                "Cultural ecology"
        ));
        questions.add(new QuizQuestion(
                "In terms of language and culture, who introduced the idea of linguistic relativity?",
                "Benjamin Lee Whorf",
                "Claude Lévi-Strauss",
                "Edward Sapir",
                "Noam Chomsky",
                "Benjamin Lee Whorf"
        ));

        questions.add(new QuizQuestion(
                "What is the concept of 'the other' in postcolonial anthropology?",
                "The marginalization or alienation of groups perceived as different from the norm",
                "The marginalization or alienation of groups perceived as different from the norm",
                "The assimilation of minority groups into the dominant culture",
                "The process of adapting foreign cultural practices",
                "The refusal to integrate foreign elements into the culture"
        ));
        questions.add(new QuizQuestion(
                "Who is known for his work on the concept of 'ritual' as a means of social integration?",
                "Victor Turner",
                "Marvin Harris",
                "Victor Turner",
                "Émile Durkheim",
                "Pierre Bourdieu"
        ));
        questions.add(new QuizQuestion(
                "Which of the following describes 'cultural diffusion'?",
                "The spread of cultural elements from one society to another",
                "The rejection of foreign cultural influences",
                "The integration of different cultural elements within a single society",
                "The reinforcement of cultural boundaries",
                "The spread of cultural elements from one society to another"
        ));
        questions.add(new QuizQuestion(
                "What is the key idea of 'human agency' in anthropology?",
                "The capacity of individuals to act independently and make their own choices",
                "The study of how environment shapes human societies",
                "The capacity of individuals to act independently and make their own choices",
                "The influence of social structures on individual behavior",
                "The role of technology in shaping cultural practices"
        ));
        questions.add(new QuizQuestion(
                "Which anthropologist developed the concept of 'the cultural system'?",
                "Alfred Radcliffe-Brown",
                "Franz Boas",
                "Alfred Radcliffe-Brown",
                "Clifford Geertz",
                "Margaret Mead"
        ));
        questions.add(new QuizQuestion(
                "What does the term 'postmodernism' in anthropology emphasize?",
                "The rejection of absolute truths and focus on multiple perspectives",
                "The universal application of scientific methods",
                "The rejection of absolute truths and focus on multiple perspectives",
                "The focus on empirical data and fieldwork",
                "The study of the political economy of societies"
        ));
        questions.add(new QuizQuestion(
                "What is the concept of 'globalization' in anthropology?",
                "The increasing interconnectedness of the world’s cultures through economic, political, and social exchanges",
                "The increasing interconnectedness of the world’s cultures through economic, political, and social exchanges",
                "The isolation of cultures through economic protectionism",
                "The division of societies into distinct and separate units",
                "The rejection of foreign cultural influences"
        ));
        questions.add(new QuizQuestion(
                "Which of the following best describes the 'interpretive approach' to anthropology?",
                "An emphasis on understanding cultural practices through the meanings that people attach to them",
                "A focus on material conditions and economic structures",
                "An analysis of power structures in societies",
                "An emphasis on understanding cultural practices through the meanings that people attach to them",
                "A method of comparing different cultures without interpretation"
        ));


        return new QuizModel("Hard Quiz",20000, questions);
    }
}
