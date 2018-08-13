package com.example.helderrocha.testeparaserinvolvido

import android.content.Context
import com.example.helderrocha.githubchallenge.api.NetworkModule
import com.example.helderrocha.githubchallenge.repository.RepositoriosActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module(includes = [
  NetworkModule::class,
  SchedulerModule::class
])
class AppModule

@Module
abstract class AndroidInjectorsModule {
  @ContributesAndroidInjector
  abstract fun repositoriosActivity(): RepositoriosActivity
//  @ContributesAndroidInjector
//  abstract fun detailsActivity(): DetailsActivity
}

@Singleton
@Component(modules = arrayOf(
    AndroidInjectionModule::class,
    AppModule::class,
    AndroidInjectorsModule::class
))
interface AppComponent : AndroidInjector<MyApp> {
  @Component.Builder
  abstract class Builder : AndroidInjector.Builder<MyApp>() {
    @BindsInstance
    abstract fun appContext(appContext: Context): Builder
  }
}