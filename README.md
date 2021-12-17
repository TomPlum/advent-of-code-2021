# :christmas_tree: Advent of Code 2021

![GitHub](https://img.shields.io/badge/stars-02%2F50-yellow)

## What is Advent of Code?

_Excerpt from the Advent of Code [website](https://adventofcode.com/2020/about);_

    "Advent of Code is an Advent calendar of small programming puzzles for a variety of skill sets
    and skill levels that can be solved in any programming language you like. People use them as a
    speed contest, interview prep, company training, university coursework, practice problems, or
    to challenge each other."

## Contents
* [Getting Started](#getting-started)
* [The Days](#the-days)
    * [The Most Fun](#the-most-fun)
    * [The Most Interesting](#the-most-interesting)
    * [The Most Challenging](#the-most-challenging)
* [Answer Table](#answer-table)
* [Advent Calendar](#advent-calendar)

## Getting Started
Simply clone or download the repository into your local environment and import it as a Gradle project in your IDE.
Running [Solutions.kt](https://git.io/JII6v) will run the parts from all the completed days, reporting all the
answers and runtimes in the console.

### Gradle Tasks
| Task      | Description                                                                                        |
|-----------|----------------------------------------------------------------------------------------------------|
| `test`    | Runs the unit tests with coverage for the `implementation`, `solutions` and `common` sub-projects. |
| `detekt`  | Runs DeteKT with the custom configuration rules defined in detekt-config.yml.                      |

### IntelliJ Run Configurations
The `.run` directory contains XML configuration files from IntelliJ. Included are configurations for running the unit
tests in the `common`, `implementation` and `solutions` Gradle sub-projects as well as for each specific day.

## Answer Table

| Day | Part 1 Answer | Avg Time | Part 2 Answer | Avg Time | Documentation                            |
|-----|---------------|----------|---------------|----------|------------------------------------------|
| 01  | 1624          | 9ms      | 1653          | 4ms      | [Sonar Sweep](docs/DAY1.MD)              |
| 02  | 1427868       | 7ms      | 1568138742    | 2ms      | [Dive!](docs/DAY2.MD)                    |
| 03  | 4160394       | 31ms     | 4125600       | 4ms      | [Binary Diagnostic](docs/DAY3.MD)        |
| 04  | 32844         | 75ms     | 4920          | 66ms     | [Giant Squid](docs/DAY4.MD)              |
| 05  | 4421          | 676ms    | 18674         | 1s 496ms | [Hydrothermal Venture](docs/DAY5.MD)     |
| 06  | 372984        | 2ms      | 1681503251694 | 2ms      | [Lanternfish](docs/DAY6.MD)              |
| 07  | 345035        | 23ms     | 97038163      | 59ms     | [The Treachery of Whales](docs/DAY7.MD)  |
| 08  | 352           | 2ms      | 936117        | 14ms     | [Seven Segment Search](docs/DAY8.MD)     |
| 09  | 560           | 147ms    | 959136        | 192ms    | [Smoke Basin](docs/DAY9.MD)              |
| 10  | 392097        | 12ms     | 4263222782    | 7ms      | [Syntax Scoring](docs/DAY10.MD)          |
| 11  | 1601          | 25ms     | 368           | 78ms     | [Dumbo Octopus](docs/DAY11.MD)           |
| 12  | 4495          | 37ms     | 131254        | 593ms    | [Passage Pathing](docs/DAY12.MD)         |
| 13  | 842           | 48ms     | BFKRCJZU      | 102ms    | [Transparent Origami](docs/DAY13.MD)     |
| 14  | 2602          | 10ms     | 2942885922173 | 15ms     | [Extended Polymerization](docs/DAY14.MD) |
| 15  | -             | -        | -             | -        | [](docs/DAY15.MD)                        |
| 16  | -             | -        | -             | -        | [](docs/DAY16.MD)                        |
| 17  | 2850          | 40ms     | 1117          | 36ms     | [Trick Shot](docs/DAY17.MD)              |
| 18  | -             | -        | -             | -        | [](docs/DAY18.MD)                        |
| 19  | -             | -        | -             | -        | [](docs/DAY19.MD)                        |
| 20  | -             | -        | -             | -        | [](docs/DAY20.MD)                        |
| 21  | -             | -        | -             | -        | [](docs/DAY21.MD)                        |
| 22  | -             | -        | -             | -        | [](docs/DAY22.MD)                        |
| 23  | -             | -        | -             | -        | [](docs/DAY23.MD)                        |
| 24  | -             | -        | -             | -        | [](docs/DAY24.MD)                        |
| 25  | -             | -        | -             | -        | [](docs/DAY25.MD)                        |

Average Execution Time: 646ms \
Total Execution Time: 15s 441ms \
i7 5820K - OpenJDK 14.0.2 - Ubuntu 20.04
