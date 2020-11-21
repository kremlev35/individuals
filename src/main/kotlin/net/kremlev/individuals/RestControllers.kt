package net.kremlev.individuals

import net.kremlev.individuals.annotations.LoggedRest
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/city", consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
class CityController(private val repository: CityRepository) {

    @PostMapping("/find")
    @LoggedRest
    fun getCityByName(@RequestBody request: GetCityByName): City? {
        return repository.findByName(request.name)
    }

    @PostMapping("/find/all")
    @LoggedRest
    fun getAllCity(): Iterable<City> {
        return repository.findAllBy()
    }

    @PostMapping("/save")
    @LoggedRest
    fun setCity(@RequestBody city: City): City {
        return repository.save(city)
    }
}

@RestController
@RequestMapping("/api/woman", consumes = [APPLICATION_JSON_VALUE], produces = [APPLICATION_JSON_VALUE])
class WomanController(private val repository: WomanRepository) {

    @PostMapping("/find/name")
    @LoggedRest
    fun getWomenByName(@RequestBody request: GetWomanByName): Iterable<Woman> {
        return repository.findAllByName(request.name)
    }

    @PostMapping("/find/age")
    @LoggedRest
    fun getWomanByAge(@RequestBody request: GetWomanByAge): Iterable<Woman> {
        return repository.findAllByAge(request.age)
    }

    @PostMapping("/save")
    @LoggedRest
    fun setWoman(@RequestBody woman: Woman): Woman {
        return repository.save(woman)
    }
}