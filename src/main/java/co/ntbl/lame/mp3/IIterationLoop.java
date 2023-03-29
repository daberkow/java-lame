package co.ntbl.lame.mp3;

/**
 * Global Type Definitions
 *
 * @author Ken
 */
public interface IIterationLoop {
  /**
   *
   * @param gfp
   * @param pe
   * @param ms_ratio
   * @param ratio
   */
  void iteration_loop(final LameGlobalFlags gfp, float pe[][],
                      float ms_ratio[], III_psy_ratio ratio[][]);
}
