package com.goldin.plugins.teamcity.messenger

import javax.servlet.http.HttpServletRequest
import jetbrains.buildServer.web.openapi.PagePlaces
import jetbrains.buildServer.web.openapi.PlaceId
import jetbrains.buildServer.web.openapi.SimplePageExtension
import jetbrains.buildServer.web.util.WebUtil
import org.jetbrains.annotations.NotNull
import jetbrains.buildServer.web.openapi.PositionConstraint


/**
 * Messenger extension
 */
class MessageDisplayExtension extends SimplePageExtension
{
    MessageDisplayExtension ( PagePlaces pagePlaces )
    {
        super( pagePlaces, PlaceId.ALL_PAGES_HEADER, Constants.PluginName, 'messageDisplay.jsp' )
        position = PositionConstraint.first()
        register()
    }

    @Override
    boolean isAvailable ( @NotNull final HttpServletRequest request )
    {
        def path = WebUtil.getPathWithoutAuthenticationType( request )
        (( path == '/' ) || path.startsWith( '/overview.html' ))
    }
}