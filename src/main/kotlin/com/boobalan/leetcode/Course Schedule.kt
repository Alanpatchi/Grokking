package com.boobalan.leetcode

import java.util.*

class `Course Schedule` {

    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val prerequisiteCountOfCourse = IntArray(numCourses)
        val courseToPrerequisiteList = mutableMapOf<Int, MutableList<Int>>()
        val prerequisiteToCourseList = mutableMapOf<Int, MutableList<Int>>()
        for (dependency in prerequisites) {
            val course = dependency[0]
            val prerequisite = dependency[1]
            prerequisiteCountOfCourse[course]++

            val currentPrerequisiteList = courseToPrerequisiteList[course]
            if (currentPrerequisiteList == null) {
                courseToPrerequisiteList[course] = mutableListOf(prerequisite)
            } else {
                currentPrerequisiteList.add(prerequisite)
            }

            val currentCourseList = prerequisiteToCourseList[prerequisite]
            if (currentCourseList == null) {
                prerequisiteToCourseList[prerequisite] = mutableListOf(course)
            } else {
                currentCourseList.add(course)
            }
        }

        // kahn's algo

        val queue = LinkedList<Int>()
        // add no-dependency nodes to queue
        for (i in prerequisiteCountOfCourse.indices) {
            if (prerequisiteCountOfCourse[i] == 0) {
                queue.add(i)
            }
        }

        // iterate through this no-dependency queue; until there is zero no dependency
        while(queue.isNotEmpty()) {
            val prerequisite = queue.poll()
            val courses = prerequisiteToCourseList[prerequisite]
            if (courses != null) {
                for (course in courses) {
                    // do the prerequisite
                    courseToPrerequisiteList[course]!!.remove(prerequisite)
                    if (courseToPrerequisiteList[course]!!.isEmpty()) {
                        courseToPrerequisiteList.remove(course)
                    }
                    prerequisiteCountOfCourse[course]--
                    if (prerequisiteCountOfCourse[course] == 0) {
                        queue.add(course)
                    }
                }
            }
        }

        // if there is no dependency graph left, then all courses are done
        return courseToPrerequisiteList.isEmpty()
    }
}