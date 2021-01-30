package com.mycodefu;

import org.lwjgl.assimp.AIScene;

import static org.lwjgl.assimp.Assimp.*;

public class EntryPoint {

    public static final String PENGUIN_PATH = "/Users/lthompson/IdeaProjects/lwjgl-penguin/src/main/resources/fluffypenguin.obj";

    public static void main(String[] args) {
        System.out.println("Hello LWJGL!");

        AIScene scene = aiImportFile(PENGUIN_PATH, aiProcess_JoinIdenticalVertices | aiProcess_Triangulate);
        if (scene == null) {
            throw new IllegalStateException(aiGetErrorString());
        }

        System.out.printf("""
                OBJ file loaded: %s
                  %d meshes loaded
                  %d textures loaded
                  %d materials loaded
                  %d animations loaded
                  %d cameras loaded
                  %d lights loaded
                """
                , PENGUIN_PATH
                , scene.mNumMeshes()
                , scene.mNumTextures()
                , scene.mNumMaterials()
                , scene.mNumAnimations()
                , scene.mNumCameras()
                , scene.mNumLights()
        );



    }
}
